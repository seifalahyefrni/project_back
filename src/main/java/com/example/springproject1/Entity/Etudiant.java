package com.example.springproject1.Entity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import énumeration.Option;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
@Builder
public class Etudiant  {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option opt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private List<Contrat> Contrats;

    @ManyToOne
    Departement departement;

    @ManyToMany(mappedBy="etudiants",cascade = CascadeType.ALL)
    private List<Equipe>equipes;

    @ManyToOne
    Classe classe;

}
