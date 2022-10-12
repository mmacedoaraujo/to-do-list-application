package com.mmacedo.todolist.config;

import com.mmacedo.todolist.services.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig {

    private final DBService dbService;

    @Bean
    public boolean instantiateMethod() {
        this.dbService.databaseInstantiationMethod();
        return true;
    }
}
