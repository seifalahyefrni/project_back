package com.example.springproject1.service;

import com.example.springproject1.Entity.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springproject1.repository.IDepartementRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartementService implements IDepartementService {
    @Autowired
    IDepartementRepository departementRepository;

    @Override
    public List<Departement> getAllDepartement(){
        List<Departement> departements = new ArrayList<Departement>();
        departementRepository.findAll().forEach(departements::add);
        return departements;
    }

    @Override
    public Departement getDepartementById(int idDepartement){
        return departementRepository.findById(idDepartement).get();
    }
    @Override
    public boolean update(Departement departement){
        if (departementRepository.existsById(departement.getIdDepart())){
            departementRepository.save(departement);
            return true;
        }
        return false;
    }

    @Override
    public int ajoutDepartement(Departement departement){
        departementRepository.save(departement);
        return departement.getIdDepart();
    }

    @Override
    public boolean deleteDepartementById(int idDepartement){
        if (departementRepository.existsById(idDepartement)){
            departementRepository.deleteById(idDepartement);
            return true;
        }
        return false;
    }


}
