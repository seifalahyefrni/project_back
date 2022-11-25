package com.example.springproject1.controller;

import com.example.springproject1.Entity.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springproject1.service.IContratService;

import java.util.List;


@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratService contratService;

    @GetMapping("/retrieve-all-contrats")
    public List<Contrat>getContrats() {

        List<Contrat> listContrats = contratService.findAll();
        return listContrats;
    }

    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") int idContrat ){
        return contratService.findByIdContrat(idContrat);
    }
    @PostMapping("/add-contrat")

    public int addContrat(@RequestBody Contrat c){

        return contratService.ajoutContrat(c);
    }

    @DeleteMapping("/remove-contrat/{contrat-id}")

    public boolean removeContratByid(@PathVariable("contrat-id") int idContrat){
       return contratService.deleteContrat(idContrat);
    }

    @PutMapping("/modify-contrat")
    public boolean modifyContrat(@RequestBody Contrat contrat){

        return contratService.updateContrat(contrat);
    }


}
