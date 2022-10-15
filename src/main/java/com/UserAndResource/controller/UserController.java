package com.UserAndResource.controller;

import com.UserAndResource.model.User;
import com.UserAndResource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
