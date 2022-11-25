package com.example.springproject1.repository;

import com.example.springproject1.Entity.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant,Integer> {
}
