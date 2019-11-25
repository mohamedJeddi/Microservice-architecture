package com.esprit.employeeservice.repository;

import com.esprit.employeeservice.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankRepository extends JpaRepository<Bank,String> {
}
