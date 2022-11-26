package com.example.springproject1.Entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepart;
    private String nomDepart;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private List<Matiére> Matiéres;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    private List<Etudiant> etudiants;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private List<Enseignant> enseignants;

}




