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
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnseignant;

    private String nom;
    private String prenom;

    @ManyToOne
    Departement departement;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Matiére> matiéres;
}
