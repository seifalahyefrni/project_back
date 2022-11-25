package com.example.springproject1.controller;

import com.example.springproject1.Entity.DetailEquipe;
import com.example.springproject1.service.IDetailEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetailEquipeController {
    @Autowired
    IDetailEquipeService detailEquipeService;

    @GetMapping("/retrieve-all-details")
    public List<DetailEquipe> getAllDetailEquipe() {
        List<DetailEquipe> detailEquipes = detailEquipeService.getAllDetailEquipe();
        return detailEquipes;
    }

    @GetMapping("/retrieve-all-details/{detail-salle}")
    public DetailEquipe getDetailEquipeBySalle(@PathVariable("detail-id") int salle) {

        return detailEquipeService.getDetailEquipeBySalle(salle);
    }

    @PostMapping("/update-detail-by-salle")
    public boolean update(@RequestBody DetailEquipe detailEquipe) {
        return detailEquipeService.update(detailEquipe);


    }
    @PostMapping("/add-detail")
    public int ajoutDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return detailEquipeService.ajoutDetailEquipe(detailEquipe);

    }


    @DeleteMapping("/delete-detail/{salle}")
    public boolean deleteDetailEquipeBySalle(@PathVariable("salle") int salle) {
        return detailEquipeService.deleteDetailEquipeBySalle(salle);
    }

}
