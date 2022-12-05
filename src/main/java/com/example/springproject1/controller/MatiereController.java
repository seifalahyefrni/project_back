package com.example.springproject1.controller;

import com.example.springproject1.Entity.Contrat;
import com.example.springproject1.Entity.Departement;
import com.example.springproject1.Entity.Matiére;
import com.example.springproject1.service.DepartementService;
import com.example.springproject1.service.IMatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matiere")
public class MatiereController {

    @Autowired
    IMatiereService matiereService;

    @Autowired
    DepartementService departementService;




    @PutMapping("/affect-departement-toMatiere/{matiere-id}/{departement-id}")
    public Matiére affectDepartementToMatiere (@PathVariable("matiere-id") int idMatiere,@PathVariable("departement-id") int idDepartement) {
        System.out.println("one");
      Matiére matiere=matiereService.findByIdMatiere(idMatiere);
        Departement departement=departementService.getDepartementById(idDepartement);
       matiere.setDepartement(departement);
       matiereService.updateMatiere(matiere);
      //  matiereService.affectDepartementToMatiere(idMatiere,idDepartement);

        return matiere;
    }
    @GetMapping("/retrieve-all-matieres")
    public List<Matiére> getMatieres() {
        List<Matiére> listMatieres = matiereService.findAll();
        return listMatieres;
    }

    @GetMapping("/retrieve-matiere/{matiere-id}")
    public Matiére retrieveMatiere(@PathVariable("matiere-id") int idMatiere ){
        return matiereService.findByIdMatiere(idMatiere);
    }

    @PostMapping("/add-matiere")
    public int addMatiere(@RequestBody Matiére m){

        return matiereService.ajoutMatiere(m);
    }

    @DeleteMapping("/remove-matiere/{matiere-id}")

    public boolean removeMatiereByid(@PathVariable("matiere-id") int idMatiere){
        return matiereService.deleteMatiere(idMatiere);
    }

    @PutMapping("/modify-matiere")
    public boolean modifyMatiere(@RequestBody Matiére m){

        return matiereService.updateMatiere(m);
    }

}
