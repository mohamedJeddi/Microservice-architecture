package com.esprit.formation.repository;

import com.esprit.formation.domain.TrainingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingSessionRepository extends JpaRepository<TrainingSession,Long> {
}
