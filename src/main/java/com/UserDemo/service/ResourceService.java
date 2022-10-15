package com.UserDemo.service;

import com.UserDemo.model.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResourceService {
    List<Resource> getAll();
    ResponseEntity<Object> getById(Long id);
    Resource create(Resource resource);
}
