package com.esprit.formation.controller;

import com.esprit.formation.domain.Participator;
import com.esprit.formation.domain.TrainingSession;
import com.esprit.formation.service.EmployeeService;
import com.esprit.formation.service.TrainingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trainingSessions")
public class TrainingSessionController {

    @Autowired
    private TrainingSessionService trainingSessionService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/{codeTrainingPlan}")
    public ResponseEntity<TrainingSession> addTrainingSession(@RequestBody TrainingSession trainingSession, @PathVariable("codeTrainingPlan") String codeTrainingPlan)
            throws ResourceNotFoundException {
        TrainingSession ts= trainingSessionService.saveTrainingSession(trainingSession,codeTrainingPlan);
        return ResponseEntity.ok(ts);
    }

    @PutMapping()
    public ResponseEntity<TrainingSession> updateEmployee(@RequestBody TrainingSession trainingSession) throws ResourceNotFoundException {
        TrainingSession ts= trainingSessionService.updateTrainingSession(trainingSession);
        return ResponseEntity.ok(ts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingSession(@PathVariable Long id) {
        ResponseEntity responseEntity;
        TrainingSession ts = trainingSessionService.getTrainingSessionById(id);
        if (!id.equals(null))
        {
            trainingSessionService.deleteTrainingSession(ts);

            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.badRequest().body("echec suppression");
        }

        return responseEntity;

    }

    @GetMapping("/{id}")
    ResponseEntity<TrainingSession> findTrainingSessionById(@PathVariable("id") Long id) {

        if (!id.equals(null)) {
            TrainingSession ts=trainingSessionService.getTrainingSessionById(id);
            return ResponseEntity.ok(ts);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping()
    ResponseEntity<List<TrainingSession>> findAllTrainingSessions() {

        List<TrainingSession> trainingSessions = trainingSessionService.getAllTrainingSessions();
        if (!trainingSessions.isEmpty()) {
            return ResponseEntity.ok(trainingSessions);
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/employeeTraining/{idSession}")
    public ResponseEntity<Participator> addEmployeeToTrainingSession(@PathVariable("idSession") Long idSession, @RequestParam("email") String email)
            throws ResourceNotFoundException {
        Participator participator= employeeService.addEmployeetoTrainingSession(email, idSession);
        return ResponseEntity.ok(participator);

    }

}
