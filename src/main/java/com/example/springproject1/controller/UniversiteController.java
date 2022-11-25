package com.example.springproject1.controller;

import com.example.springproject1.Entity.Universite;
import com.example.springproject1.service.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversiteController {
    @Autowired
    IUniversiteService universiteService;

    @GetMapping("/retrieve-all-universites")
    public List<Universite> getAllUniversite()
    {
        List<Universite> universites = universiteService.getAllYUniversite();
        return universites;
    }

    @GetMapping("/retrieve-all-universites/{universite-id}")
    public Universite getUniversiteById(@PathVariable("universite-id") int id)
    {

        return universiteService.getUniversiteById(id);
    }


    @PostMapping("/update-universite-by-id")
    public boolean update(@RequestBody Universite universite)
    {
        return universiteService.update(universite);


    }

    @PostMapping("/add-universite")
    public int ajoutUniversite(@RequestBody Universite universite){
        return universiteService.ajoutUniversite(universite);

    }


    @DeleteMapping("/delete-universite/{universite-id}")
    public boolean deleteUniversiteById(@PathVariable("universite-id") int idUniversite) {
        return  universiteService.deleteUniversiteById(idUniversite);
    }


}
