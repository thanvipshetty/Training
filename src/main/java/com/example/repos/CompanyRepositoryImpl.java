package com.example.repos;

import com.example.ifaces.CrudRepository;
import com.example.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CrudRepository<Company> {

    private JdbcTemplate template;

    @Autowired
    public CompanyRepositoryImpl(JdbcTemplate template) {
        super();
        this.template = template;
    }

    @Override
    public boolean save(Company entity) {
        String sql = "insert into company_details values(?,?,?)";
        int rowAdded =  template.update(sql,entity.getCompanyId(),entity.getCompanyName(),entity.getCompanyLocation());
        return rowAdded==1;
    }

    @Override
    public List<Company> findAll() {
        String sql="select * from company_details";
        return template.query(sql, BeanPropertyRowMapper.newInstance(Company.class));
    }

    @Override
    public Company findById(Long id) {
        String sql="select * from company_details where company_id = ?";
        return template.queryForObject(sql,BeanPropertyRowMapper.newInstance(Company.class),id);
    }
}
