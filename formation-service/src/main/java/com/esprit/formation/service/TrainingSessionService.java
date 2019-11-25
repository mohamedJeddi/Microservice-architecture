package com.esprit.formation.service;

import com.esprit.formation.domain.TrainingSession;

import java.util.List;

public interface TrainingSessionService {

    TrainingSession saveTrainingSession (TrainingSession trainingSession, String codeTrainingPlan);

    TrainingSession updateTrainingSession(TrainingSession trainingSession);

    void deleteTrainingSession (TrainingSession trainingSession);

    List<TrainingSession> getAllTrainingSessions();

    TrainingSession getTrainingSessionById(Long id);
}
