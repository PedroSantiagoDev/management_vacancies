package com.pedrosantiago.management_vacancies.modules.candidate.controllers;

import com.pedrosantiago.management_vacancies.exceptions.UserFoundException;
import com.pedrosantiago.management_vacancies.modules.candidate.CandidateEntity;
import com.pedrosantiago.management_vacancies.modules.candidate.CandidateRepository;
import com.pedrosantiago.management_vacancies.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CreateCandidateUseCase candidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            CandidateEntity res = this.candidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
