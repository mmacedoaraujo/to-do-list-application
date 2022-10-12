package com.mmacedo.todolist.services;

import com.mmacedo.todolist.domain.Todo;
import com.mmacedo.todolist.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class DBService {

    private final TodoRepository repository;

    public void databaseInstantiationMethod() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo todo = new Todo(1,
                "Meditar",
                "Meditar por 30 minutos hoje",
                LocalDateTime.parse("12/10/2022 15:30", formatter),
                false);

        repository.save(todo);
    }
}
