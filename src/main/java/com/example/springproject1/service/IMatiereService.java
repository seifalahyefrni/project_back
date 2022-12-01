package com.example.springproject1.service;
import com.example.springproject1.Entity.Matiére;
import java.util.List;

public interface IMatiereService {

    boolean deleteMatiere(int idMatiere);
    boolean updateMatiere(Matiére m);
    int ajoutMatiere(Matiére m);
    Matiére findByIdMatiere(int idMatiere);
    List<Matiére> findAll();
    Matiére affectDepartementToMatiere (int idMatiere,int idDepartement);
}
