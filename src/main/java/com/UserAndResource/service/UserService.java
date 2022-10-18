package com.UserAndResource.service;

import com.UserAndResource.dto.UserByIdDto;
import com.UserAndResource.dto.UserResponseDto;
import com.UserAndResource.model.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {
    UserResponseDto getAll(int pageNo, int pageSize, String sortBy, String sortDir);
    UserByIdDto getById(Long id);
    HttpStatus create(List<User> users);
}
