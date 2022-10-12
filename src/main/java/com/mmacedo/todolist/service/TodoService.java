package com.mmacedo.todolist.service;

import com.mmacedo.todolist.domain.Todo;
import com.mmacedo.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public Todo findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Todo> listOpenTasks() {
        return repository.listOpenTasks();
    }

    public List<Todo> listFinishedTasks() {
        return repository.listFinishedTasks();
    }
}
