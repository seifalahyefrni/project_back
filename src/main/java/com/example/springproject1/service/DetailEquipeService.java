package com.example.springproject1.service;

import com.example.springproject1.Entity.DetailEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springproject1.repository.IDetailEquipeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailEquipeService implements IDetailEquipeService {
    @Autowired
    private IDetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> getAllDetailEquipe() {
        List<DetailEquipe> detailEquipes = new ArrayList<DetailEquipe>();
        detailEquipeRepository.findAll().forEach(detailEquipes::add);
        return detailEquipes;
    }

    @Override
    public DetailEquipe getDetailEquipeBySalle(int salle) {
        return detailEquipeRepository.findById(salle).get();
    }
    @Override
    public boolean update(DetailEquipe detailEquipe) {
        if (detailEquipeRepository.existsById(detailEquipe.getSalle())){
            detailEquipeRepository.save(detailEquipe);
            return true;
        }
        return false;
    }
    @Override
    public int ajoutDetailEquipe(DetailEquipe detailEquipe) {
        detailEquipeRepository.save(detailEquipe);
        return detailEquipe.getSalle();
    }
    @Override
    public boolean deleteDetailEquipeBySalle(int salle) {
        if (detailEquipeRepository.existsById(salle)) {
            detailEquipeRepository.deleteById(salle);
            return true;
        }
        return false;
    }
}
