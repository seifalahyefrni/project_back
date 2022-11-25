package com.example.springproject1.Entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import énumeration.NiveauClasse;
import énumeration.Specialite;

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
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClasse;


    private int numero;
    @Enumerated(EnumType.STRING)
    private NiveauClasse niveauClasse;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Matiére> matiéres;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="classe")
    private List<Etudiant> Etudiants;


}
