package com.example.springproject1.service;

import com.example.springproject1.Entity.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springproject1.repository.IContratRepository;

import java.util.List;


@Service
public class ContratService implements IContratService {
    @Autowired

    IContratRepository contratRepository;



    public boolean deleteContrat(int idContrat) {
        if(contratRepository.existsById(idContrat))
        {contratRepository.deleteById(idContrat);            
            return true;
        }else
            return false;
    }
    
    public boolean updateContrat(Contrat c) {
        if (contratRepository.existsById(c.getIdContrat())){
            contratRepository.save(c);
            return true;}
        else 
            return false;
        
    }

  
    public int ajoutContrat(Contrat c) {
        return contratRepository.save(c).getIdContrat();
    }
    
    public Contrat findByIdContrat(int idContrat) {
        return contratRepository.findById(idContrat).get();

    }

    public List<Contrat> findAll() {


        return (List<Contrat>) contratRepository.findAll();
    }
    
}

    
   