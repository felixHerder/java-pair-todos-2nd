package com.felixherder.todo.service;

import com.felixherder.todo.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.felixherder.todo.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
    public UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        MyUserDetails myUserDetails = new MyUserDetails(user);
        return myUserDetails;
    }
}
