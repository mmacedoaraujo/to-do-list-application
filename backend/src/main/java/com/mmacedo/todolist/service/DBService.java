package com.mmacedo.todolist.service;

import com.mmacedo.todolist.domain.Todo;
import com.mmacedo.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class DBService {

    private final TodoRepository repository;

    public void databaseInstantiationMethod() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11", sdf.parse("25/03/2022"), false);
        Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal", sdf.parse("22/03/2021"), true);
        Todo t3 = new Todo(null, "Exercicios", "Praticar exercicios fisicos", sdf.parse("21/03/2022"), false);


        repository.saveAll(Arrays.asList(t1, t2, t3));
    }
}
