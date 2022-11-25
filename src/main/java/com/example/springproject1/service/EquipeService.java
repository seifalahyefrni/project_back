package com.example.springproject1.service;

import com.example.springproject1.Entity.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springproject1.repository.IEquipeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipeService implements IEquipeService{
    @Autowired
    private IEquipeRepository equipeRepository;
    @Override
    public List<Equipe>getAllEquipe(){
        List<Equipe> equipes = new ArrayList<Equipe>();
        equipeRepository.findAll().forEach(equipes::add);
        return equipes;
    }
    @Override
    public Equipe getEquipeById(int idEquipe) {

        return equipeRepository.findById(idEquipe).get();
    }
    @Override
    public boolean update(Equipe equipe) {
        if (equipeRepository.existsById(equipe.getIdEquipe())){
            equipeRepository.save(equipe);
            return true;
        }
        return false;
    }
    @Override
    public int ajoutEquipe(Equipe equipe) {
        equipeRepository.save(equipe);
        return equipe.getIdEquipe();
    }
    @Override
    public boolean deleteEquipeById(int idEquipe) {
        if (equipeRepository.existsById(idEquipe)) {
            equipeRepository.deleteById(idEquipe);
            return true;
        }
        return false;
    }

}
