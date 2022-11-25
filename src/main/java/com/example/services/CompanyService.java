package com.example.services;

import com.example.model.Company;
import com.example.repos.CompanyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepositoryImpl repo;

    public boolean save(Company entity){
        return this.repo.save(entity);
    }

    public List<Company> findAll(){
        return this.repo.findAll();
    }

    public Company findById(Long id){
        return this.repo.findById(id);
    }



}
