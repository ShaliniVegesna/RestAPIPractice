package com.UserAndResource.controller;

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
    public ResponseEntity<Object> getAll(@RequestParam int page){
        List<User> userList =  userService.getAll();
        Map<String, Object> responceMap = new HashMap<>();
        if(page ==2) {
            Map<String, Object> supportData = new HashMap<>();
            supportData.put("url", "https://reqres.in/#support-heading");
            supportData.put("text", "To keep ReqRes free, contributions towards server costs are appreciated!");
            responceMap.put("page", 2);
            responceMap.put("per_page", 6);
            responceMap.put("total", 12);
            responceMap.put("total_pages", 2);
            responceMap.put("data", userList);
            responceMap.put("support", supportData);
        }
        return new ResponseEntity<>(responceMap, HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @PostMapping("/users")
    public List<User> create(@RequestBody List<User> users) {
        return userService.create(users);
    }
}
