package com.esprit.formation.service;

import com.esprit.formation.domain.TrainingPlan;
import com.esprit.formation.domain.TrainingSession;
import com.esprit.formation.repository.TrainingPlanRepository;
import com.esprit.formation.repository.TrainingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

    @Autowired
    private TrainingSessionRepository trainingSessionRepository;

    @Autowired
    private TrainingPlanRepository trainingPlanRepository;

    @Override
    public TrainingSession saveTrainingSession(TrainingSession trainingSession, String codeTrainingPlan) {
        TrainingPlan trainingPlan= new TrainingPlan();
        trainingPlan = trainingPlanRepository.findTrainingPlanByCode(codeTrainingPlan);
        trainingSession.addTrainingPlan(trainingPlan);
        return trainingSessionRepository.save(trainingSession);
    }

    @Override
    public TrainingSession updateTrainingSession(TrainingSession trainingSession) {
        return trainingSessionRepository.saveAndFlush(trainingSession);
    }

    @Override
    public void deleteTrainingSession(TrainingSession trainingSession) {
        trainingSessionRepository.deleteById(trainingSession.getId());
    }

    @Override
    public List<TrainingSession> getAllTrainingSessions() {
        return trainingSessionRepository.findAll();
    }

    @Override
    public TrainingSession getTrainingSessionById(Long id) {
        TrainingSession trainingSession=trainingSessionRepository.findById(id).get();
        if(trainingSession!=null)
            return trainingSession;
        return null;
    }
}
