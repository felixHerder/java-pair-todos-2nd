package com.felixherder.todo.controller;

import com.felixherder.todo.model.Todo;
import com.felixherder.todo.service.MyUserDetailsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class UserController {
    private final MyUserDetailsService myUserDetailsService;

    @GetMapping("/")
    public String getTodos(Model model, Authentication authentication){
        String username = authentication.getName();
        model.addAttribute("todos", myUserDetailsService.userRepo.findByUsername(username).getTodoList());

        return "todo-list";
    }
}
