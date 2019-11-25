package com.esprit.departementservice.service;

import com.esprit.departementservice.domain.Deaprtement;
import com.esprit.departementservice.repository.DeaprtementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    public DeaprtementRepository deaprtementRepository;


    @Override
    public Deaprtement saveDeaprtement(Deaprtement deaprtement) {
        return deaprtementRepository.save(deaprtement);
    }

    @Override
    public Deaprtement updateDeaprtement(Deaprtement deaprtement) {
        return deaprtementRepository.saveAndFlush(deaprtement);
    }

    @Override
    public void deleteDeaprtement(Deaprtement deaprtement) {
        deaprtementRepository.deleteById(deaprtement.getId());
    }

    @Override
    public List<Deaprtement> getAllDeaprtements() {
        return deaprtementRepository.findAll();
    }

    @Override
    public Deaprtement getDeaprtementById(Long id) {

        Deaprtement deaprtement = deaprtementRepository.findById(id).get();
        if (deaprtement!=null) {
            return deaprtement;
        }
        return null;
    }
}
