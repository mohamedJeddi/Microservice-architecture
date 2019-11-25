package com.esprit.contratservice.service;

import com.esprit.contratservice.domain.Contrat;
import com.esprit.contratservice.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService {

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public Contrat saveContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.saveAndFlush(contrat);
    }

    @Override
    public void deleteContrat(Contrat contrat) {
        contratRepository.deleteById(contrat.getId());
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepository.findById(id).get();
    }
}
