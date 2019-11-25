package com.esprit.departementservice.controller;

import com.esprit.departementservice.domain.Deaprtement;
import com.esprit.departementservice.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departements")
public class DepartementController {

    @Autowired
    public DepartementService departementService;

    @PostMapping()
    public ResponseEntity<Deaprtement> addDeaprtement(@RequestBody Deaprtement deaprtement) throws ResourceNotFoundException {
        Deaprtement dep = departementService.saveDeaprtement(deaprtement);
        return ResponseEntity.ok(dep);
    }

    @PutMapping()
    public ResponseEntity<Deaprtement> updateDeaprtement(@RequestBody Deaprtement deaprtement) throws ResourceNotFoundException {
        Deaprtement dep = departementService.updateDeaprtement(deaprtement);
        return ResponseEntity.ok().body(dep);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeaprtement(@PathVariable Long id) {
        ResponseEntity responseEntity;
        Deaprtement deaprtement = departementService.getDeaprtementById(id);
        if (!id.equals(null))

        {
            departementService.deleteDeaprtement(deaprtement);

            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.badRequest().body("echec suppression");
        }

        return responseEntity;

    }

    @GetMapping("/{id}")
    ResponseEntity<Deaprtement> findEmployeeById(@PathVariable("id") Long id) {

        if (!id.equals(null)) {
            Deaprtement deaprtement=departementService.getDeaprtementById(id);
            return ResponseEntity.ok(deaprtement);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping()
    ResponseEntity<List<Deaprtement>> findAllDeaprtement() {

        List<Deaprtement> deaprtements = departementService.getAllDeaprtements();
        if (!deaprtements.isEmpty()) {
            return ResponseEntity.ok(deaprtements);
        }

        return ResponseEntity.notFound().build();

    }
}
