package com.esprit.contratservice.service;

import com.esprit.contratservice.domain.Contrat;

import java.util.List;

public interface ContratService {

    Contrat saveContrat (Contrat contrat);

    Contrat updateContrat (Contrat contrat);

    void deleteContrat (Contrat contrat);

    List<Contrat> getAllContrats();

    Contrat getContratById(Long id);

}
