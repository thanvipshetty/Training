package com.example;

import com.example.model.Company;
import com.example.services.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJdbc1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx= SpringApplication.run(SpringJdbc1Application.class, args);
        CompanyService companyService = ctx.getBean(CompanyService.class);
        int key=3;
        switch (key){
            case 1:
                Company obj = ctx.getBean(Company.class);
                obj.setCompanyId(Integer.parseInt(args[0]));
                obj.setCompanyName(args[1]);
                obj.setCompanyLocation(args[2]);
                System.out.println(obj);
                System.out.println("Company details got added (true or false) :" + companyService.save(obj));
                break;
            case 2:
               companyService.findAll().forEach(System.out::print);
               break;
            case 3:
                System.out.println("Company details od id 111 is :" +companyService.findById(111l));
                break;
        }
        ctx.close();
    }

//    @Bean
//    public Company tieto(){
//       // return new Company(110,"capgemini","pune");
//       //return new Company(111,"evry","chennai");
//      return new Company(117,"tcs","delhi");
//    }
    }


