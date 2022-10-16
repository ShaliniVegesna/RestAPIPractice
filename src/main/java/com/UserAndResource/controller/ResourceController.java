package com.UserAndResource.controller;

import com.UserAndResource.model.Resource;
import com.UserAndResource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    @GetMapping("/resources")
    public ResponseEntity<Object> getAll(@RequestParam int page){
        List<Resource> resourceList =  resourceService.getAll();
        Map<String, Object> responceMap = new HashMap<>();
        if(page ==2) {
            Map<String, Object> supportData = new HashMap<>();
            supportData.put("url", "https://reqres.in/#support-heading");
            supportData.put("text", "To keep ReqRes free, contributions towards server costs are appreciated!");
            responceMap.put("page", 2);
            responceMap.put("per_page", 6);
            responceMap.put("total", 12);
            responceMap.put("total_pages", 2);
            responceMap.put("data", resourceList);
            responceMap.put("support", supportData);
        }
        return new ResponseEntity<>(responceMap, HttpStatus.OK);
    }
    @GetMapping("/resources/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return resourceService.getById(id);
    }
    @PostMapping("/resources")
    public List<Resource> create(@RequestBody List<Resource> resources) {
        return resourceService.create(resources);
    }
}

