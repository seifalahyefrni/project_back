package com.example.springproject1.service;

import com.example.springproject1.Entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springproject1.repository.IEtudiantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantService implements IEtudiantService{
    @Autowired
    private IEtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> getAllEtudiant() {
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        etudiantRepository.findAll().forEach(etudiants::add);
        return etudiants;
    }
    @Override
    public Etudiant getEtudiantById(int idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public boolean update(Etudiant etudiant) {
        if (etudiantRepository.existsById(etudiant.getIdEtudiant())){
            etudiantRepository.save(etudiant);
            return true;
        }
        return false;
    }
    @Override
    public int ajoutEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return etudiant.getIdEtudiant();
    }

    @Override
    public boolean deleteEtudiantById(int idEtudiant) {
        if (etudiantRepository.existsById(idEtudiant)) {
            etudiantRepository.deleteById(idEtudiant);
            return true;
        }
        return false;
    }

}
