package com.pedrosantiago.management_vacancies.modules.company.useCases;

import com.pedrosantiago.management_vacancies.exceptions.UserFoundException;
import com.pedrosantiago.management_vacancies.modules.company.entities.CompanyEntity;
import com.pedrosantiago.management_vacancies.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });
        return this.companyRepository.save(companyEntity);
    }
}
