package com.pedrosantiago.management_vacancies.modules.candidate.useCases;

import com.pedrosantiago.management_vacancies.exceptions.UserFoundException;
import com.pedrosantiago.management_vacancies.modules.candidate.CandidateEntity;
import com.pedrosantiago.management_vacancies.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });
        return this.candidateRepository.save(candidateEntity);
    }
}
