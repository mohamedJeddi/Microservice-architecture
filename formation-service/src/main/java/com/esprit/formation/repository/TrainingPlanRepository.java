package com.esprit.formation.repository;

import com.esprit.formation.domain.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan,Long> {

    TrainingPlan findTrainingPlanByCode(String code);
}
