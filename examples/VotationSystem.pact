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


    (defun create_Votante (Name Voted)

      (insert Votante_table Name {"Voted": Voted})
    )
    (defun create_Candidato (Name Votos)

      (insert Candidato_table Name {"Votos": Votos})
    )


    (defun voted_for (votante candidato)
      (with-read Votante_table votante {"Voted" := votante_Voted } 
       (with-read Candidato_table candidato {"Votos" := candidato_Votos } 
        (enforce (!= votante_Voted true) "El Votante ya ha votado")
        (update Votante_table votante {"Voted": true })
        (update Candidato_table candidato {"Votos": (+ candidato_Votos 1) })))
    )
 )

(create-table Votante_table)
(create-table Candidato_table)
(create_Votante "Andres" false)
(create_Votante "Jose" false)
(create_Votante "Juan" false)
(create_Candidato "Nestor" 0)
(voted_for "Andres" "Nestor")
(voted_for "Jose" "Nestor")
(voted_for "Juan" "Nestor")
