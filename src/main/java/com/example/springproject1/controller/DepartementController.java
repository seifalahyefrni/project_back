package com.example.springproject1.controller;

import com.example.springproject1.service.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springproject1.Entity.Departement;
import com.example.springproject1.service.IDepartementService;

import java.util.List;


@RestController
public class DepartementController {
    @Autowired
    IDepartementService departementService;

    @GetMapping("/retrieve-all-departements")
    public List<Departement> getAllDepartements()
    {
        List<Departement> departements= departementService.getAllDepartement();
        return departements;
    }

    @GetMapping("/retrieve-all-department/{department-id}")
    public Departement getDepartmentById(@PathVariable("deparetment-id") int idDepartement)
    {

        return departementService.getDepartementById(idDepartement);
    }

    @PostMapping("/update-department-by-id")
    public boolean update(@RequestBody Departement departement)
    {
        return departementService.update(departement);


    }
    @PostMapping("/add-departement")
    public int ajoutDepartement(@RequestBody Departement departement) {
        return departementService.ajoutDepartement(departement);

    }
    @DeleteMapping("/delete-contrat/{contrat-id}")
    public boolean deleteDepartemenyById(@PathVariable("departement-id") int idDepartement) {
        return departementService.deleteDepartementById(idDepartement);
    }
}