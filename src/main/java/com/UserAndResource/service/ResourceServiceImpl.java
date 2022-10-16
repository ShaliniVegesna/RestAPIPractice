package com.UserAndResource.service;

import com.UserAndResource.model.Resource;
import com.UserAndResource.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
    @Service
    public class ResourceServiceImpl implements ResourceService{
        @Autowired
        private ResourceRepository resourceRepository;

        @Override
        public List<Resource> getAll() {
            List<Resource> resources = new ArrayList<>();
            resourceRepository.findAll().forEach(resources::add);
            return resources;
        }

        @Override
        public ResponseEntity<Object> getById(Long id) {
            if(resourceRepository.findById(id).isPresent()){
                return new ResponseEntity<>(resourceRepository.findById(id).get(), HttpStatus.OK);
            }
            else if(resourceRepository.findById(id).isEmpty()){
                return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
            }
            return null;
        }

        @Override
        public List <Resource> create(List<Resource> resources) {
            resources.forEach(resource->resourceRepository.save(resource));
            return getAll();
        }

    }
