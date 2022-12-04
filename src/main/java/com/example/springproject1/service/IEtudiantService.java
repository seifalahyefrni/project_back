package com.example.springproject1.service;

import com.example.springproject1.Entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant>getAllEtudiant();
    public Etudiant getEtudiantById(int idEtudiant);
    public boolean update(Etudiant etudiant);

    public int ajoutEtudiant(Etudiant etudiant);

    public List<Etudiant> getEtudiantByNomPrenom(String nom,String prenom);
    boolean deleteEtudiantById(int idEtudiant);
}
