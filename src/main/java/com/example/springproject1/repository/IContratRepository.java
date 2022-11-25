package com.example.springproject1.repository;

import com.example.springproject1.Entity.Contrat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContratRepository extends CrudRepository<Contrat,Integer> {

    @Query("select contrat from Contrat contrat join Universite universite on contrat.etudiant.departement member universite.Departements where universite.idUniv=?1")
    public List<Contrat> getListContratBy(int x);







}
