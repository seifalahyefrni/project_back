package com.example.springproject1.service;

import com.example.springproject1.Entity.Equipe;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> getAllEquipe();
    public Equipe getEquipeById(int idEquipe);
    public boolean update(Equipe equipe);

    public int ajoutEquipe(Equipe equipe);


    boolean deleteEquipeById(int idEquipe);
}
