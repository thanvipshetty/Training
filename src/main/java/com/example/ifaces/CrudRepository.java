package com.example.ifaces;

import com.example.model.Company;

import java.util.List;

public interface CrudRepository<C> {
    boolean save(Company entity);
    List<Company> findAll();
    Company findById(Long id);


}
