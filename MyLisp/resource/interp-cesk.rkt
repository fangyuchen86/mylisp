#lang racket

(require rackunit)

(define ext-env
  (lambda (key value env)
    (cons (cons key (box value)) env)))

(define multi-ext-env
  (lambda (keys values env)
    (if (> (length keys) 0)
        (multi-ext-env (cdr keys) (cdr values) (ext-env (car keys) (car values) env))
        env)))

(define lookup
  (lambda (x env)
    (let ([p (assoc x env)])
      (cond
       [(not p) x]
       [else (cdr p)]))))

(struct End-Cont ())

(define end-cont (End-Cont))

(struct If-Cont (ncont et ef ))

(struct Begin-Cont (ncont seqs ))

(struct Set-Cont (ncont x ))

(struct Def-Cont (ncont x ))

(struct Closure (args exp env))

(struct Evfun-Cont (ncont vals))

(struct Apply-Cont (ncont fun-val))

(struct Argument-Cont (ncont other-arguments))

(struct Gather-Cont (ncont val))



(define resume
  (lambda (cont value env)
    (match cont
      [(End-Cont) (get-value value)]
      [(If-Cont ncont et ef )
       (if value (interp1 et env ncont)
           (interp1 ef env ncont))]
      [(Begin-Cont ncont seqs )
       (evaluate-begin seqs env ncont)]
      [(Set-Cont ncont x )
       (begin (update! x (get-value value) env)
              (resume ncont (void) env))]
      [(Def-Cont ncont x)
       (let ([new-env (ext-env x (get-value value) env)])
         (resume ncont (void) new-env))]
      [(Evfun-Cont ncont vals) 
       (evaluate-arguments vals env (Apply-Cont ncont value))]
      [(Argument-Cont ncont other-arguments)
       (evaluate-arguments other-arguments env (Gather-Cont ncont (get-value value)))]
      [(Gather-Cont ncont val) (resume ncont (cons val value) env)]
      [(Apply-Cont ncont fun-val)
       (match (get-value fun-val)
         [(Closure args exp env)
          (interp1 exp (multi-ext-env args value env) ncont)]
         [(? procedure? fun)
          (resume ncont (apply fun value) env)])])))



(define (interp-primitive-fun fun-name args vals)
  (match fun-name
    ['+ (apply + vals)]
    ['- (apply - vals)]
    ['* (apply * vals)]
    ['/ (apply / vals)]
    ['eq? (apply eq? vals)]))

(define evaluate-arguments
  (lambda (vals env cont)
    (let ([len (length vals)])
      (cond
       [(eq? len 0) (resume cont '() env)]
       [else (interp1 (car vals) env (Argument-Cont cont (cdr vals)))]))))

(define get-value
  (lambda (v) 
    (if (box? v) (unbox v) v)))

(define evaluate-begin
  (lambda (seqs env cont)
    (let [(len (length seqs))]
      (cond 
       [(eq? len 0) (resume cont (void))]
       [(eq? len 1) (interp1 (car seqs) env cont)]
       [else (interp1 (car seqs) env (Begin-Cont cont (cdr seqs) ))]))))

(define update!
  (lambda (x v env)
    (let ([b (lookup x env)])
      (if (box? b)
          (set-box! b v)
          (void)))))


(define interp1
  (lambda (exp env cont)
    (match exp
      [(? boolean? x) (resume cont x env)]
      [(? string? x) (resume cont x env)]
      [(? number? x) (resume cont x env)]
      [(? symbol? x) (resume cont (lookup x env) env)]
      [`(if ,test ,exp1 ,exp2) 
       (interp1 test env (If-Cont cont exp1 exp2))]
      [(list 'begin seqs ... ) (evaluate-begin seqs env cont)]
      [`(set! ,x ,exp) (interp1 exp env (Set-Cont cont x))]
      [`(define ,x ,exp) (interp1 exp env (Def-Cont cont x))]
      [`(lambda ,args ,exp) (resume cont (Closure args exp env) env)]
      [(list fun-val vals ...) (interp1 fun-val env (Evfun-Cont cont vals))])))

;;for test
(define env1 (ext-env 'a 6 '()))
(define env (ext-env 'b 106 env1))

(check-equal? (lookup 'a env) (box 6))

(check-equal? (interp1 'a env end-cont) 6)
(check-equal? (interp1 100 env end-cont) 100)
(check-equal? (interp1 "hello" env end-cont) "hello")
(check-equal? (interp1 #t env end-cont) #t)
(check-equal? (interp1 '(if #t a 100) env end-cont) 6)
(check-equal? (interp1 '(if #f a 100) env end-cont) 100)

(check-equal? (interp1 '(begin 5) env end-cont) 5)
(check-equal? (interp1 '(begin 5 6) env end-cont) 6)
(check-equal? (interp1 '(begin 5 (if #t a 100)) env end-cont) 6)

(check-equal? (interp1 '(begin (set! a 100) a) env end-cont) 100)
(check-equal? (interp1 '(begin (set! a 200) 100 (set! b 101) b) env end-cont) 101)


(check-equal? (interp1 '(begin (define e 200) e) env end-cont) 200)
(check-equal? (interp1 '(begin (define e 200) (set! e 300) e) env end-cont) 300)

(define env2 (multi-ext-env '(a b) '(1 100) '()))
;(check-equal? (interp1 '(begin (define e (lambda () 100)) (e)) env end-cont) 100)
(check-equal? (interp1 '(begin (define e (lambda (i) i)) (e a)) env2 end-cont) 1)


(define env3 (multi-ext-env '(a b) '(1 100) '()))
(check-equal? (interp1 '(begin (define e (lambda (i x) x)) (e a b)) env3 end-cont) 100)


(define env4 (multi-ext-env '(a b) '(1 100) '()))
(check-equal? (interp1 '(begin (define e (lambda (i x) (+ i x))) (e a b)) env4 end-cont) 100)
