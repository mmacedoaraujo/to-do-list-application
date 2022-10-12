package com.mmacedo.todolist;

import com.mmacedo.todolist.domain.Todo;
import com.mmacedo.todolist.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RequiredArgsConstructor
public class TodoListApplication implements CommandLineRunner {

    private final TodoRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo todo = new Todo(1,
                "aaa",
                "aaa",
                LocalDateTime.parse("25/03/2022 10:40", formatter),
                false);

        repository.save(todo);
    }
}
