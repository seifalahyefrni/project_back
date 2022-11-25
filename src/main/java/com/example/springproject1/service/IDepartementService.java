package com.example.springproject1.service;

import com.example.springproject1.Entity.Departement;

import java.util.List;

public interface IDepartementService {
public List<Departement>getAllDepartement();

public Departement getDepartementById(int idDepartement);
public boolean update(Departement departement);
public int ajoutDepartement(Departement departement);
boolean deleteDepartementById(int idDepartement);

}
