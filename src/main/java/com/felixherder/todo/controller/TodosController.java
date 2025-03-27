package com.felixherder.todo.controller;

import com.felixherder.todo.model.Todo;
import com.felixherder.todo.model.TodoCreateDto;
import com.felixherder.todo.service.MyUserDetails;
import com.felixherder.todo.service.MyUserDetailsService;
import com.felixherder.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.felixherder.todo.model.User;

@RequiredArgsConstructor
@Controller
public class TodosController {
    private final UserService userService;
    private final MyUserDetailsService myUserDetailsService;

    @GetMapping("/todo/create")
    public String todoCreateForm() {
        return "todo-create-form";
    }

    @PostMapping("/todo/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createTodo(@ModelAttribute TodoCreateDto todoCreateDto, Authentication authentication) {
        String username = authentication.getName();
        User user = myUserDetailsService.userRepo.findByUsername(username);
        this.userService.updateUser(todoCreateDto, user);

       return "todo-create-form";
    }
}
