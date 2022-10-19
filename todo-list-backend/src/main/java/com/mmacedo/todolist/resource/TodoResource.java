package com.mmacedo.todolist.resource;

import com.mmacedo.todolist.domain.Todo;
import com.mmacedo.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/todos")
public class TodoResource {

    private final TodoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        Todo todoObject = service.findById(id);

        return new ResponseEntity<>(todoObject, HttpStatus.OK);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> listOpen() {
        List<Todo> todoList = service.listOpenTasks();

        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @GetMapping(value = "/finished")
    public ResponseEntity<List<Todo>> listFinished() {
        List<Todo> finishedTodosList = service.listFinishedTasks();

        return new ResponseEntity<>(finishedTodosList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAll() {
        List<Todo> todos = service.listAll();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        Todo createdTodo = service.create(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).body(createdTodo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Todo todo) {
        service.update(id, todo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
