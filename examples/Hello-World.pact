(define-keyset 'admin-keyset (read-keyset "admin-keyset"))
(module contract 'admin-keyset


    (defun Hello_World ()
      (format "Hello World" [])
    )


 )

( Hello_World )
