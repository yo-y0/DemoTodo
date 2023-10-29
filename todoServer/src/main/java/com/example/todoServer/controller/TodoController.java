package com.example.todoServer.controller;

import com.example.todoServer.entity.CompletionStatus;
import com.example.todoServer.entity.Todo;
import com.example.todoServer.entity.User;
import com.example.todoServer.exception.Exception;
import com.example.todoServer.repository.TodoRepository;
import com.example.todoServer.repository.UserRepository;
import com.example.todoServer.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/getAllTodos")
    public ResponseEntity<List<Todo>> getTodo() {
        return ResponseEntity.ok(todoService.getAllTodo());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Todo>> getTodoById(@PathVariable Long userId) {
        return ResponseEntity.ok(todoService.getTodoByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Todo> addTodos(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.addNewTodo(todo));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodos(@PathVariable Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{todoId}")
    public void updateTodo(
            @PathVariable Long todoId,
            @RequestBody Todo todo
    ){
        todoService.updateTodo(todoId,todo);
    }

}
