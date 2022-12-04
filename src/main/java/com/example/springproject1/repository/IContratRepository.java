package com.example.springproject1.repository;

import com.example.springproject1.Entity.Contrat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContratRepository extends CrudRepository<Contrat,Integer> {
    @Modifying
    @Query(value = "update Contrat c set c.etudiant= (select e from Etudiant e where e.nomE=:nomE and e.prenomE=:prenomE) where c.idContrat=:ce")
    public void affectContratToEtudiant(@Param("ce") int ce,@Param("nomE") String nomE,@Param("prenomE") String prenomE);

    @Query("select contrat from Contrat contrat join Universite universite on contrat.etudiant.departement member universite.Departements where universite.idUniv=?1")
    public List<Contrat> getListContratBy(int x);







}
