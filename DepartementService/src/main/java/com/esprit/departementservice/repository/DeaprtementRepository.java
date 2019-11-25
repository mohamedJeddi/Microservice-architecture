package com.esprit.departementservice.repository;

import com.esprit.departementservice.domain.Deaprtement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeaprtementRepository extends JpaRepository<Deaprtement,Long> {
}
