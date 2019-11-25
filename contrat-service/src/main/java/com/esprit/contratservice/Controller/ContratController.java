package com.esprit.contratservice.Controller;

import com.esprit.contratservice.domain.Contrat;
import com.esprit.contratservice.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;


    @PostMapping()
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat) throws ResourceNotFoundException {
        Contrat contrat1 = contratService.saveContrat(contrat);
        return ResponseEntity.ok(contrat1);
    }

    @PutMapping()
    public ResponseEntity<Contrat> updateContrat(@RequestBody Contrat contrat) throws ResourceNotFoundException {
        Contrat contrat1 = contratService.updateContrat(contrat);
        return ResponseEntity.ok().body(contrat1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        ResponseEntity responseEntity;
        Contrat contrat = contratService.getContratById(id);
        if (!id.equals(null))

        {
            contratService.deleteContrat(contrat);

            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.badRequest().body("echec suppression");
        }

        return responseEntity;

    }

    @GetMapping("/{id}")
    ResponseEntity<Contrat> findContratById(@PathVariable("id") Long id) {

        if (!id.equals(null)) {
            Contrat contrat=contratService.getContratById(id);
            return ResponseEntity.ok(contrat);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping()
    ResponseEntity<List<Contrat>> findAllContrat() {

        List<Contrat> allContrats = contratService.getAllContrats();
        if (!allContrats.isEmpty()) {
            return ResponseEntity.ok(allContrats);
        }

        return ResponseEntity.notFound().build();

    }
}
