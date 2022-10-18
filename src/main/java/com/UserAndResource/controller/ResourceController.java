package com.UserAndResource.controller;

import com.UserAndResource.model.Resource;
import com.UserAndResource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    @GetMapping("/resources")
    public ResponseEntity<?> getAll(@RequestParam(value = "page", defaultValue = "1", required = false) int pageNo){
        return new ResponseEntity<>(resourceService.getAll(pageNo,6,"id","asc"), HttpStatus.OK);
    }
    @GetMapping("/resources/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(resourceService.getById(id),HttpStatus.OK);
    }
    @PostMapping("/resources")
    public HttpStatus create(@RequestBody List<Resource> resources) {
        return resourceService.create(resources);
    }
}

