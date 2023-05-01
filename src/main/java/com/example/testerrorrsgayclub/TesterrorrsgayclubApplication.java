package com.example.testerrorrsgayclub;

import com.example.testerrorrsgayclub.repository.BankClientsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TesterrorrsgayclubApplication {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(TesterrorrsgayclubApplication.class);
//
//        BankClientsRepository bankClientsRepository = context.getBean(BankClientsRepository.class);
//
//        System.out.println(bankClientsRepository.getBankClientById(1));

        SpringApplication.run(TesterrorrsgayclubApplication.class, args);
    }

}
