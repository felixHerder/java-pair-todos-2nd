package com.felixherder.todo.repository;


import com.felixherder.todo.model.User;
import com.felixherder.todo.service.MyUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByUsername(String name);
}
