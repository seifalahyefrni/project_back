package com.example.springproject1.service;


import com.example.springproject1.Entity.Contrat;

import java.util.List;

public interface IContratService {
    boolean deleteContrat(int idContrat);
    boolean updateContrat(Contrat c);
    int ajoutContrat(Contrat c);
    Contrat findByIdContrat(int idContrar);
    List<Contrat> findAll();

}
