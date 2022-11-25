package com.example.springproject1.controller;

import com.example.springproject1.Entity.Equipe;
import com.example.springproject1.service.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipeController {
    @Autowired
    IEquipeService equipeService;
    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getAllEquipe()
    {
        List<Equipe> equipes = equipeService.getAllEquipe();
        return equipes;
    }
    @GetMapping("/retrieve-all-equipes/{equipe-id}")
    public Equipe getEquipeById(@PathVariable("equipe-id") int id)
    {

        return equipeService.getEquipeById(id);
    }


    @PostMapping("/update-equipe-by-id")
    public boolean update(@RequestBody Equipe equipe)
    {
        return equipeService.update(equipe);


    }

    @PostMapping("/add-equipe")
    public int ajoutEquipe(@RequestBody Equipe equipe) {
        return equipeService.ajoutEquipe(equipe);

    }


    @DeleteMapping("/delete-equipe/{equipe-id}")
    public boolean deleteContratById(@PathVariable("equipe-id") int idEquipe) {
        return  equipeService.deleteEquipeById(idEquipe);
    }

}
