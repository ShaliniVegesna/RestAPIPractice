package com.UserAndResource.controller;

import com.UserAndResource.exception.UserNotFoundException;
import com.UserAndResource.model.User;
import com.UserAndResource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ResponseEntity<?> getAll(@RequestParam(value = "page", defaultValue = "1", required = false) int pageNo){
        return new ResponseEntity<>(userService.getAll(pageNo,6,"id","asc"), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }
    @PostMapping("/users")
    public HttpStatus create(@RequestBody List<User> users) {
        return userService.create(users);
    }
}
