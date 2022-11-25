package com.example.springproject1.Entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import énumeration.Niveau;

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
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Etudiant>etudiants;

    @OneToOne(mappedBy="equipe")
    private DetailEquipe detailEquipe;
}
