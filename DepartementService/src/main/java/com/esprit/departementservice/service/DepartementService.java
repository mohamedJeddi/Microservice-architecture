package com.esprit.departementservice.service;

import com.esprit.departementservice.domain.Deaprtement;

import java.util.List;

public interface DepartementService {

    Deaprtement saveDeaprtement (Deaprtement employee);

    Deaprtement updateDeaprtement (Deaprtement employee);

    void deleteDeaprtement (Deaprtement employee);

    List<Deaprtement> getAllDeaprtements();

    Deaprtement getDeaprtementById(Long id);

}
