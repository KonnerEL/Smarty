(define-keyset 'admin-keyset (read-keyset "admin-keyset"))
(module contract 'admin-keyset
    (defschema Account
      Balance:decimal
    )


    (deftable Account_table:{Account})


    (defun create_Account (Name initial_balance)
     (enforce (> initial_balance 0.0) "Initial balance must be >= 0")
      (insert Account_table Name {"Balance": initial_balance})
    )


    (defun transfer_to (from to amount)
      (with-read Account_table from {"Balance" := from_Balance }
       (with-read Account_table to {"Balance" := to_Balance }
        (enforce (> amount 0.0) "Negative Transaction Amount")
        (enforce (>= from_Balance amount) "Insufficient Funds")
        (update Account_table from {"Balance": (- from_Balance amount) })
        (update Account_table to {"Balance": (+ to_Balance amount) })))
    )

    (defun get_info_Account (ID1 ID2)
      (with-read Account_table ID1 {"Balance" := ID1_Balance}
       (with-read Account_table ID2 {"Balance" := ID2_Balance}
        (format " {} - {} \n {} - {} " [ID1,ID1_Balance,ID2,ID2_Balance])))
    )
 )

(create-table Account_table)
(create_Account "Jose" 100.25)
(create_Account "Nestor" 250.0)
(transfer_to "Jose" "Nestor" 25.0)
(get_info_Account "Nestor" "Jose")
