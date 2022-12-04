package com.example.springproject1.repository;

import com.example.springproject1.Entity.Etudiant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant,Integer> {

    @Query("select e from Etudiant e where e.nomE=:nom and e.prenomE=:prenom")
    public List<Etudiant> getEtudiantByNomPrenom(@Param("nom") String nom, @Param("prenom") String prenom);
}
