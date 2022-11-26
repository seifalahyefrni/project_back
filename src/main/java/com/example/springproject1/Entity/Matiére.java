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
public class Matiére {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatiére;
    private String nom;
    private int nombre_horaire;

 
    @ManyToOne
    Departement departement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="matiére")
    private List<Examen> examens;

    @ManyToMany(mappedBy="matiéres", cascade = CascadeType.ALL)
    private List<Classe> classes;
}
