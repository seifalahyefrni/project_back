package com.example.springproject1.service;

import com.example.springproject1.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> getAllYUniversite();
    public Universite getUniversiteById(int idUniv);
    public boolean update(Universite universite);

    public int ajoutUniversite(Universite universite);


    boolean deleteUniversiteById(int idUniv);
}
