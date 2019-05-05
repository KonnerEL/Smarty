(define-keyset 'admin-keyset (read-keyset "admin-keyset"))
(module contract 'admin-keyset
    (defschema Item
      MAX_BID:decimal
    )

    (defschema Bettor
      BID:decimal
    )


    (deftable Item_table:{Item})

    (deftable Bettor_table:{Bettor})


    (defun create_Item (Name MAX_BID)

      (insert Item_table Name {"MAX_BID": MAX_BID})
    )
    (defun create_Bettor (Name Bid)

      (insert Bettor_table Name {"BID": Bid})
    )


    (defun bid_for (bettor item bid)
      (with-read Bettor_table bettor {"BID" := bettor_BID}
       (with-read Item_table item {"MAX_BID" := item_MAX_BID}
        (enforce (> bid item_MAX_BID) "Must enter with greater Bid")
        (update Bettor_table bettor {"BID": bid })
        (update Item_table item {"MAX_BID": bid })))
    )

    (defun get_info_Item (ID1)
      (with-read Item_table ID1 {"MAX_BID" := ID1_MAX_BID}
       (format " {} - {} " [ID1,ID1_MAX_BID]))
    )
 )

( create-table Item_table )
( create-table Bettor_table )
( create_Item "Lamborghini_Veneno" 10.0)
( create_Bettor "Pedro" 10.0)
( bid_for "Pedro" "Lamborghini_Veneno" 10.0)
( create_Bettor "Juan" 70.0)
( bid_for "Juan" "Lamborghini_Veneno" 70.0)
( get_info_Item "Lamborghini_Veneno")
