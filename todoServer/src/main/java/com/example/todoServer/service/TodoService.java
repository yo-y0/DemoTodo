package com.example.todoServer.service;

import com.example.todoServer.entity.CompletionStatus;
import com.example.todoServer.entity.Todo;
import com.example.todoServer.entity.User;
import com.example.todoServer.exception.Exception;
import com.example.todoServer.repository.TodoRepository;
import com.example.todoServer.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public Todo addNewTodo(Todo todo) {
        //Check if userId exist
        Optional<User> userExist = userRepository.findById(todo.getUserId());
        //if does not exist, throw something
        if(userExist.isEmpty()){throw new Exception.UserExistsException();}
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public List<Todo> getTodoByUserId(long userId) {
        List<Todo> todoList = todoRepository.findByUserId(userId);
        if(todoList.isEmpty()){throw new NoSuchElementException();}
        return todoList;
    }

    public void deleteTodo(long todoId){
        //gettheTodoList based on userId
        Optional<Todo> todo = todoRepository.findById(todoId);
        if(todo.isEmpty()){throw new NoSuchElementException();}
        todoRepository.deleteById(todoId);
    }

    @Transactional
    public void updateTodo(Long todoId, Todo todo) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);

        if (optionalTodo.isPresent()) {
            Todo existingTodo = optionalTodo.get();

            if (todo.getContent() != null) {
                existingTodo.setContent(todo.getContent());
            }

            if (todo.getStatus() != null) {
                existingTodo.setStatus(todo.getStatus());
            }

            todoRepository.save(existingTodo);
        } else {
            throw new NoSuchElementException("Todo with ID " + todoId + " not found.");
        }
    }
}
