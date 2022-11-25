package com.example.springproject1.service;

import com.example.springproject1.Entity.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    public List<DetailEquipe> getAllDetailEquipe();
    public DetailEquipe getDetailEquipeBySalle(int salle);
    public boolean update(DetailEquipe detailEquipe);

    public int ajoutDetailEquipe(DetailEquipe detailEquipe);


    boolean deleteDetailEquipeBySalle(int salle);
}
