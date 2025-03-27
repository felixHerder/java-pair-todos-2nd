package com.felixherder.todo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String role;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Todo> todoList = new ArrayList<>();
}
