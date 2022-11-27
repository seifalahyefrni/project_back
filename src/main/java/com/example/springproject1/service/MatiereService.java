package com.example.springproject1.service;

import com.example.springproject1.Entity.Contrat;
import com.example.springproject1.Entity.Matiére;
import com.example.springproject1.repository.IMatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService implements IMatiereService{

    @Autowired
    IMatiereRepository matiereRepository;

 public boolean deleteMatiere(int idMatiere){
     if(matiereRepository.existsById(idMatiere))
     {matiereRepository.deleteById(idMatiere);
         return true;
     }else
         return false;
 }


   public boolean updateMatiere(Matiére m){
       if (matiereRepository.existsById(m.getIdMatiére())){
           matiereRepository.save(m);
           return true;}
       else
           return false;
   }
  public int ajoutMatiere(Matiére m){
      return matiereRepository.save(m).getIdMatiére();

  }
 public Matiére findByIdMatiere(int idMatiere){
     return matiereRepository.findById(idMatiere).get();
 }
  public   List<Matiére> findAll(){
      return (List<Matiére>) matiereRepository.findAll();
    }

}
