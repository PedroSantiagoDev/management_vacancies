package com.pedrosantiago.management_vacancies.modules.company.repositories;

import com.pedrosantiago.management_vacancies.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
