package com.example.springproject1.repository;

import com.example.springproject1.Entity.Contrat;
import com.example.springproject1.Entity.Matiére;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.PrintStream;

@Repository
public interface IMatiereRepository extends CrudRepository<Matiére,Integer> {

    @Modifying
    @Query("update Matiére m set m.departement= :idDepartement where m.idMatiére=:idMatiere")
    public Void affectDepartementToMatiere(@Param("idMatiere") int idMatiere,@Param("idDepartement") int idDepartement);
}
