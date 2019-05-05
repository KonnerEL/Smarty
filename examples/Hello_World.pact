(define-keyset 'admin-keyset (read-keyset "admin-keyset"))
(module contract 'admin-keyset


    (defun hello_world ()
      (format "Hello World" [])
    )


 )

( hello_world )
