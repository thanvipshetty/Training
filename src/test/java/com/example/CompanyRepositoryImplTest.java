package com.example;

import com.example.ifaces.CrudRepository;
import com.example.model.Company;
import com.example.repos.CompanyRepositoryImpl;
import com.example.services.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.ObjectInputFilter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@SpringBootTest
//@DataJpaTest
//ContextConfiguration(classes = ObjectInputFilter.Config.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//@JdbcTest
//@ActiveProfiles("test")
@Rollback
public class CompanyRepositoryImplTest {
    @Autowired
    private CompanyRepositoryImpl companyRepository;
    @Autowired
    private JdbcTemplate template;


    @Test
    //@Rollback(true)
    @Transactional
    public void addNewCompanyDetails()  {
       Company c = new Company();
       c.setCompanyName("del");
       c.setCompanyLocation("delhi");
        boolean newdetails = companyRepository.save(c);
        Assertions.assertEquals(true,newdetails);
       // Assertions.assertNotNull(template);
//        when(companyRepository.findById((long) c.getCompanyId())).thenReturn(c);
//        when(companyRepository.save(c)).thenReturn(true);
//        boolean savedCompany = companyService.save(c);
    }
    @Test
   // @Rollback(value = true)
    public void testFindAll(){

        Assertions.assertEquals(28,companyRepository.findAll().size());
    }

    @Test
    public void testFindById(){
        Company validCompany = companyRepository.findById(115L);
        Assertions.assertNotNull(validCompany);
        Assertions.assertEquals("tcs",validCompany.getCompanyName());
        Assertions.assertEquals("delhi",validCompany.getCompanyLocation());

    }


}
