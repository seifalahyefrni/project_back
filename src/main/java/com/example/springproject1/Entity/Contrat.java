package com.example.springproject1.Entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import énumeration.Specialite;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
@Builder

public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite  ;
    private Boolean archive ;
    @ManyToOne
    Etudiant etudiant;
}
