package com.mmacedo.todolist.config;

import com.mmacedo.todolist.service.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig {

    private final DBService dbService;

    public boolean instantiateMethod() throws ParseException {
        this.dbService.databaseInstantiationMethod();
        return true;
    }
}
