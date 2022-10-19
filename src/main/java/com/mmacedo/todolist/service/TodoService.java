package com.mmacedo.todolist.service;

import com.mmacedo.todolist.domain.Todo;
import com.mmacedo.todolist.repository.TodoRepository;
import com.mmacedo.todolist.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public Todo findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Todo.class.getName()));
    }

    public List<Todo> listOpenTasks() {
        return repository.listOpenTasks();
    }

    public List<Todo> listFinishedTasks() {
        return repository.listFinishedTasks();
    }

    public List<Todo> listAll() {
        return repository.findAll();
    }

    public Todo create(Todo todo) {
        todo.setId(null);
        return repository.save(todo);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
