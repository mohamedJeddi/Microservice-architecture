package com.esprit.formation.service;

import com.esprit.formation.domain.Participator;

public interface EmployeeService {

    Participator addEmployeetoTrainingSession(String email, Long idSession);
}
