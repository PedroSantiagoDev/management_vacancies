package com.pedrosantiago.management_vacancies.modules.company.controllers;

import com.pedrosantiago.management_vacancies.modules.candidate.useCases.CreateCandidateUseCase;
import com.pedrosantiago.management_vacancies.modules.company.entities.CompanyEntity;
import com.pedrosantiago.management_vacancies.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CreateCompanyUseCase companyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            CompanyEntity res = this.companyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
