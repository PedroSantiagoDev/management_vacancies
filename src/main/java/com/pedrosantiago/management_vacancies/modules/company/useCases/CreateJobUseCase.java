package com.pedrosantiago.management_vacancies.modules.company.useCases;

import com.pedrosantiago.management_vacancies.modules.company.entities.JobEntity;
import com.pedrosantiago.management_vacancies.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {
    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
