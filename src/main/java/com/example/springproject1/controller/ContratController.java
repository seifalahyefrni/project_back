package com.example.springproject1.controller;

import com.example.springproject1.Entity.Contrat;
import com.example.springproject1.Entity.Etudiant;
import com.example.springproject1.emailSender.EmailSenderService;
import com.example.springproject1.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import com.example.springproject1.service.IContratService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratService contratService;
    @Autowired
     EmailSenderService senderService;
    @Autowired
    EtudiantService etudiantService;




    @PutMapping("/affect-contrat-tostudent/{student-nom}/{student-prenom}")
    public Contrat affectContratToEtudiant (@RequestBody Contrat ce,@PathVariable("student-nom") String nomE,@PathVariable("student-prenom") String prenomE) {

        List<Etudiant> listE=etudiantService.getEtudiantByNomPrenom(nomE,prenomE);
        Etudiant etudiant=listE.get(0);
        int e=calc(ce);
        ce.setNbre_jours_rest(e);
        ce.setEtudiant(etudiant);
      contratService.updateContrat(ce);

    //  calnbrejoursvalide();
   //  senderService.sendMail(etudiant.getEmail(),"Affectation de contrat","this is body");
        Contrat cc=contratService.findByIdContrat(ce.getIdContrat());
        return cc;
    }

    public int calc(Contrat ce){
        Date dd=ce.getDateDebutContrat();
        Date df=ce.getDateFinContrat();
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateD = simpleDateFormat.format(dd);
        String dateF = simpleDateFormat.format(df);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format jour / mois / année
        LocalDate date1 = LocalDate.parse(dateD, format);
        LocalDate date2 = LocalDate.parse(dateF, format);
        Period period = Period.between(date1, date2);
        int nbre=(period.getMonths()*30)+(period.getYears()*365)+(period.getDays());
        return nbre;
    }
    @Scheduled(cron ="1 1 1 * * *")
    public void calnbrejoursvalide(){
        List<Contrat> list=contratService.findAll();
        for (Contrat c: list) {
            int nbre=calc(c);
            c.setNbre_jours_rest(nbre);
            contratService.updateContrat(c);
            
        }
    }
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
