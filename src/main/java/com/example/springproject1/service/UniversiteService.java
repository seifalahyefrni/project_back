package com.example.springproject1.service;

import com.example.springproject1.Entity.Universite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springproject1.repository.IUniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversiteService implements IUniversiteService{
    @Autowired
    IUniversiteRepository universiteRepository;
    @Override
    public List<Universite> getAllYUniversite() {
        List<Universite> universites = new ArrayList<Universite>();
        universiteRepository.findAll().forEach(universites::add);
        return universites;
    }

    @Override
    public Universite getUniversiteById(int idUniv) {
        return universiteRepository.findById(idUniv).get();
    }

    @Override
    public boolean update(Universite universite) {
        if (universiteRepository.existsById(universite.getIdUniv())){
            universiteRepository.save(universite);
            return true;
        }
        return false;
    }

    @Override
    public int ajoutUniversite(Universite universite) {
        universiteRepository.save(universite);
        return universite.getIdUniv();
    }

    @Override
    public boolean deleteUniversiteById(int idUniv) {
        if (universiteRepository.existsById(idUniv)) {
            universiteRepository.deleteById(idUniv);
            return true;
        }
        return false;
    }
}
