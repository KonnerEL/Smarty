(define-keyset 'admin-keyset (read-keyset "admin-keyset"))
(module contract 'admin-keyset
    (defschema Item
      Quantity:integer
      Price:decimal
    )

    (defschema Customer
      Balance:decimal
    )


    (deftable Item_table:{Item})

    (deftable Customer_table:{Customer})


    (defun create_Item (Name Quantity Price)
     (enforce (> Quantity 0) "Quantity always must be > 0")
      (insert Item_table Name {"Quantity": Quantity,"Price": Price})
    )


    (defun buy_item (Customer Item Quantity)
      (with-read Customer_table Customer {"Balance" := Customer_Balance}
       (with-read Item_table Item {"Quantity" := Item_Quantity,"Price" := Item_Price}
        (enforce (>= Item_Quantity Quantity) "Unavailable Item")
        (enforce (<= (* Item_Price Quantity) Customer_Balance) "Don't have enough money")
        (update Customer_table Customer {"Balance": (- Customer_Balance (* Item_Price Quantity)) })
        (update Item_table Item {"Quantity": (- Item_Quantity Quantity) })))
    )


 )

( create-table Item_table )
( create-table Customer_table )
( create_Item "Colgate" 12 5.000)
