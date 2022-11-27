package com.example.springproject1.repository;

import com.example.springproject1.Entity.Matiére;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatiereRepository extends CrudRepository<Matiére,Integer> {
}
