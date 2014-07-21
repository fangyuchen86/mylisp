#lang racket


(struct Closure (args exp env))

(struct Primitive-fun (fun-name args))

(define pri-add (Primitive-fun '+ '(v1 v2)))

(define pri-minus (Primitive-fun '- '(v1 v2)))

(define pri-multi (Primitive-fun '* '(v1 v2)))

(define pri-divide (Primitive-fun '/ '(v1 v2)))

(define pri-eq? (Primitive-fun 'eq? '(v1 v2)))

(define env0 `((+ . ,pri-add) (- . ,pri-minus) (* . ,pri-multi) (/ . ,pri-divide)
               (eq? . ,pri-eq?)))

(define ext-env
  (lambda (key value env)
    (cons (cons key value) env)))


(define lookup
  (lambda (x env)
    (let ([p (assoc x env)])
      (cond
       [(not p) x]
       [else (cdr p)]))))



(define (interp-primitive-fun fun-name args env)
  (let* ([mapfun (lambda(x) (lookup x env))]
         [vals (map mapfun args)])
    (match fun-name
      ['+ (apply + vals)]
      ['- (apply - vals)]
      ['* (apply * vals)]
      ['/ (apply / vals)]
      ['eq? (apply eq? vals)])))


(define (interp-binds binds env)
  (if (empty? binds)
      env
      (let* ((bind (car binds))
             (key (car bind))
             (value (interp1 (cadr bind) env)))
        (interp-binds  (cdr binds) (ext-env key value env)))))


(define (interp-seq seqs env)
  (let [(len (length seqs))]
    (cond 
     [(eq? len 0) null]
     [(eq? len 1) (interp1 (car seqs) env)]
     [else (begin
             (interp1 (car seqs) env)
             (interp-seq (cdr seqs) env))])))

(define (bind-args args vals env)
  (let [(len-args (length args))
        (len-vals (length vals))]
    (if (or (not (eq? len-args len-vals)) (eq? len-args 0))
        env
        (bind-args (cdr args) (cdr vals) (ext-env (car args) (interp1 (car vals) env) env)))))

(define (interp-multi-vals vals env)
  (map (lambda (val) (interp1 val env)) vals))

;; 解释器的递归定义(接受两个参数,表达式 exp 和环境 env)
;; 共 5 种情况（变量，函数，调用，数字，算术表达式）
(define interp1
  (lambda (exp env)
    (match exp                                          ; 模式匹配 exp 的以下情况（分支）
      [(? boolean? x) x]
      [(? string? x) x]
      [(? number? x) x]   
      [(? symbol? x) (lookup x env)]                    ; 变量
      [`(box ,exp) (box (interp1 exp env))]
      [`(unbox ,exp) (let ([v (interp1 exp env)])
                       (if (box? v) (unbox v) '()))]
      [`[set! ,exp1 ,exp2] (let ([v (interp1 exp1 env)])
                            (if (box? v) (set-box! v (interp1 exp2 env))
                                '()))]
      [`(let ,binds ,exp)  
       (let ([new-env (interp-binds binds env)])                       ;绑定
         (interp1 exp new-env))]
      [(list 'begin seqs ... ) (interp-seq seqs env)] ;sequence
      [`(if ,test ,exp1 ,exp2) (if (interp1 test env0) ; if 表达式
                                   (interp1 exp1 env0)
                                   (interp1 exp2 env0))]
      [`(lambda ,args ,exp)                                ; 函数
       (Closure args exp env)]
      [(list e1 vals ...)                                       ; 调用
       (let ([v1 (interp1 e1 env)]
             [interp-vals (interp-multi-vals vals env)])
         (match v1
           [(Closure args exp env1)
            (interp1 exp (bind-args args interp-vals env1))]
           [(Primitive-fun fun-name args) 
            (interp-primitive-fun fun-name args (bind-args args interp-vals env0))]))])))

;; 解释器的“用户界面”函数。它把 interp1 包装起来，掩盖第二个参数，初始值为 env0

(define interp
  (lambda (exp)
    (interp1 exp env0)))

(define exp
  '(let [(myadd (lambda (x y z) (+ (+ x y ) z)))
         (x 100)
         (y 20)]
    (eq? -279 (- 40 ( myadd ( + x y) 99 100)))))

