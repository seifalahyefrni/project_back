package com.example.springproject1.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import énumeration.Specialite;

import javax.persistence.*;
import java.text.DateFormat;
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
@JsonIgnoreProperties({ "idContrat ","etudiant"})
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    private int nbre_jours_rest;
    @Enumerated(EnumType.STRING)
    private Specialite specialite  ;
    private Boolean archive ;
    @ManyToOne
    Etudiant etudiant;
}
