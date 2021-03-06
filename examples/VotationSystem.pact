(define-keyset 'admin-keyset (read-keyset "admin-keyset"))
(module contract 'admin-keyset
    (defschema Votante
      Voted:bool
    )

    (defschema Candidato
      Votos:integer
    )


    (deftable Votante_table:{Votante})

    (deftable Candidato_table:{Candidato})


    (defun create_Votante (Name)

      (insert Votante_table Name {"Voted": false})
    )
    (defun create_Candidato (Name)

      (insert Candidato_table Name {"Votos": 0})
    )


    (defun voted_for (votante candidato)
      (with-read Votante_table votante {"Voted" := votante_Voted}
       (with-read Candidato_table candidato {"Votos" := candidato_Votos}
        (enforce (!= votante_Voted true) "El Votante ya ha votado")
        (update Votante_table votante {"Voted": true })
        (update Candidato_table candidato {"Votos": (+ candidato_Votos 1) })))
    )

    (defun get_info_Candidato (ID1)
      (with-read Candidato_table ID1 {"Votos" := ID1_Votos}
       (format " {} - {} " [ID1,ID1_Votos]))
    )
 )

( create-table Votante_table )
( create-table Candidato_table )
( create_Votante "Andres")
( create_Votante "Jose")
( create_Votante "Juan")
( create_Candidato "Nestor")
( voted_for "Andres" "Nestor")
( voted_for "Jose" "Nestor")
( voted_for "Juan" "Nestor")
( get_info_Candidato "Nestor")
