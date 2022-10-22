package com.mmacedo.todolist.service;

import com.mmacedo.todolist.domain.Todo;
import com.mmacedo.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class DBService {

    private final TodoRepository repository;

    public void databaseInstantiationMethod() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Todo todo1 = new Todo(null, "Meditar", "Meditar por 30 minutos hoje",
                simpleDateFormat.parse("12/10/2022"), false);
        Todo todo2 = new Todo(null, "Estudar Spring Boot", "Estudar Spring boot por uma hora",
                simpleDateFormat.parse("13/10/2022"), true);
        Todo todo3 = new Todo(null, "Estudar Angular 12", "Iniciar estudos sobre Angular",
                simpleDateFormat.parse("14/10/2022"), false);
        Todo todo4 = new Todo(null, "Estudar SQL", "Continuar curso de SQL",
                simpleDateFormat.parse("16/10/2022"), true);

        repository.saveAll(Arrays.asList(todo1, todo2, todo3, todo4));
    }
}
