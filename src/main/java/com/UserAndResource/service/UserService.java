package com.UserAndResource.service;

import com.UserAndResource.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();
    ResponseEntity<Object> getById(Long id);
    User create(User user);
}
