package com.UserAndResource.service;

import com.UserAndResource.model.User;
import com.UserAndResource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public ResponseEntity<Object> getById(Long id) {
        if(userRepository.findById(id).isPresent()){
            return new ResponseEntity<>(userRepository.findById(id).get(),HttpStatus.OK);
        }
        else if(userRepository.findById(id).isEmpty()){
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

}
