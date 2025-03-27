package com.felixherder.todo.service;

import com.felixherder.todo.model.Todo;
import com.felixherder.todo.model.TodoCreateDto;
import com.felixherder.todo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.felixherder.todo.model.User;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public void updateUser(TodoCreateDto todoCreateDto, User user){
        if(user.getTodoList() == null){
            user.setTodoList(new ArrayList<>());
        }
        Todo todo = todoCreateDto.mapToTodo();
        user.getTodoList().add(todo);
        userRepo.save(user);
    }

    public Todo getTodoById(int id, User user){
        Todo todo = user.getTodoList().stream().filter(t-> t.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Todo with " + id + " not found"));
        return todo;
    }
}
