package com.example.springproject1.controller;

import com.example.springproject1.Entity.Etudiant;
import com.example.springproject1.service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantService;
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getAllEetudiants()
    {
        List<Etudiant> etudiants = etudiantService.getAllEtudiant();
        return etudiants;
    }
    @GetMapping("/retrieve-all-etudiants/{etudiant-id}")
    public Etudiant getEtudiantById(@PathVariable("etudint-id") int id)
    {

        return etudiantService.getEtudiantById(id);
    }


    @PostMapping("/update-etudiant-by-id")
    public boolean update(@RequestBody Etudiant etudiant)
    {
        return etudiantService.update(etudiant);


    }

    @PostMapping("/add-etudiant")
    public int ajoutEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.ajoutEtudiant(etudiant);

    }


    @DeleteMapping("/delete-etudiant/{etudiant-id}")
    public boolean deleteEtudiantById(@PathVariable("etudiant-id") int idEtudiant) {
        return  etudiantService.deleteEtudiantById(idEtudiant);
    }

}
