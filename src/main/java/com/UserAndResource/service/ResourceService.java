package com.UserAndResource.service;

import com.UserAndResource.dto.ResourceByIdDto;
import com.UserAndResource.dto.ResourceResponseDto;
import com.UserAndResource.model.Resource;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ResourceService {
    ResourceResponseDto getAll(int pageNo, int pageSize, String sortBy, String sortDir);
    ResourceByIdDto getById(Long id);
    HttpStatus create(List<Resource> resources);
}
