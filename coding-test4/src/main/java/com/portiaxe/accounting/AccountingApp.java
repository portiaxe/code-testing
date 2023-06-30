package com.portiaxe.accounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AccountingApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AccountingApp.class, args);
    }
}
