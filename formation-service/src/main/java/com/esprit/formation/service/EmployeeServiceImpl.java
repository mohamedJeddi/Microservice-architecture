package com.esprit.formation.service;

import com.esprit.formation.client.EmployeeResourceFeign;
import com.esprit.formation.domain.Participator;
import com.esprit.formation.domain.TrainingSession;
import com.esprit.formation.repository.ParticipatorRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeResourceFeign employeeResourceFeign;

    @Autowired
    private ParticipatorRepository participatorRepository;

    @Autowired
    private TrainingSessionService trainingSessionService;

    private Participator getEmployeeByEmail(String email){

        try {

          final Participator ps = employeeResourceFeign.findEmployeeByEmail(email).getBody();
          return ps;
        }catch (FeignException e){
            throw new EntityNotFoundException("Unable to find participator");
        }
    }

    @Override
    public Participator addEmployeetoTrainingSession(String email, Long idSession) {
        Participator participator = getEmployeeByEmail(email);

        TrainingSession trainingSession=trainingSessionService.getTrainingSessionById(idSession);

        participator=participator.addTrainingSession(trainingSession);

        participator= participatorRepository.save(participator);

        return participator;
    }
}
