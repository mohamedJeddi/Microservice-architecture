package com.esprit.formation.client;

import com.esprit.formation.domain.Participator;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="employee-service")
public interface EmployeeResourceFeign {

    @GetMapping("/employees/byEmail")
    ResponseEntity<Participator> findEmployeeByEmail(@RequestParam String email);
}
