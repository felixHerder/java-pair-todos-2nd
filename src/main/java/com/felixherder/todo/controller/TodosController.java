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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

       return "redirect:todo-list";
    }

    @GetMapping("/todo/update")
    public String todoUpdateForm(@RequestParam int id, Model model, Authentication authentication) {
        String username = authentication.getName();
        User user = myUserDetailsService.userRepo.findByUsername(username);
        Todo todo = this.userService.getTodoById(id,user);
        model.addAttribute("todo", todo);

        return "todo-update-form";
    }

    // TODO finish post update todo endpoint
    @PostMapping("/todo/update")
    public String todoUpdate(@RequestParam int id, Model model, Authentication authentication) {
        String username = authentication.getName();
        User user = myUserDetailsService.userRepo.findByUsername(username);
        Todo todo = this.userService.getTodoById(id,user);
        model.addAttribute("todo", todo);

        return "todo-update-form";
    }
}
