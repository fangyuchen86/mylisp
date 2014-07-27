#lang racket

(define (evalute exp env cont)
  (if (atom? exp)
      (cond [(symbol? exp) (evalute-variable exp env cont)]
            [else (evaluate-quota exp env cont)])
      (case (car e)
        [(quote) (evaluate-quote (cadr exp) env cont)]
        [(if) (evaluate-if (cadr exp) (caddr exp) (cadddr e) env cont)]
        [(begin) (evalute-begin (cdr exp) env cont)]
        [(set!) (evaluate-set! (cadr exp) (caddr exp) env cont)]
        [(lambda) (evaluate-lambda (cadr exp) (cddr exp) env cont)]
        [else (evaluate-application (car exp) (cdr e) env cont)])   
      ))

(struct Cont (cont))

(struct If-Cont Cont (expT expF env))
(struct Begin-Cont Cont  (expList env))
(struct Set!-Cont Cont (x env))

(define (invoke f exp env cont))

(define (resume cont val)
  (match cont
    [(If-Cont in-cont expT expF env)
     (evaluate (if val expT expF) env in-cont)]
    [(Begin-Cont in-cont expList env) 
     (evaluate-begin (cdr expList) env in-cont)]
    [(Set!-Cont in-cont x env) (update! env x cont val)]
    ))

(define (lookup env id cont))

(define (update! env id cont val)
  (let ([p (lookup-ref env id)])
    (if (eq? p id)
        '()
        (begin
          (set-box! p val)
          (resume cont val)))))


(define (evaluate-quote exp env cont)
  (resume cont exp))

(define (evaluate-if ec et ef env cont)
  (evaluate ec env (If-cont cont et ef env)))

(define (evaluate-begin expList env cont)
  (if (pair? expList)
      (if (pair? (cdr expList))
          (evaluate (car expList) env (Begin-Cont cont expList env))
          (evaluate (car expList) env cont))
      (resume cont empty-begin-value)))

(define (evaluate-set! x exp env cont)
  (evaluate exp env (Set!-Cont cont x env)))

(define env0 '())

(define (ext-env key value env)
  (cons (cons key (box value)) env))


(define (lookup-val env id cont)
  (let ([p (assoc id env)])
    (cond
     [(not p) id]
     [else (resume cont (unbox (cdr p)))])))

(define (lookup-ref env id)
  (let ([p (assoc id env)])
    (cond
     [(not p) id]
     [else (cdr p)])))





