package com.esprit.formation.repository;

import com.esprit.formation.domain.Participator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ParticipatorRepository extends JpaRepository<Participator,Long> {
}
