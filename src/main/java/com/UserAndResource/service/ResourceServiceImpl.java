package com.UserAndResource.service;

import com.UserAndResource.dto.*;
import com.UserAndResource.exception.ResourceNotFoundException;
import com.UserAndResource.model.Resource;
import com.UserAndResource.model.User;
import com.UserAndResource.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
    @Service
    public class ResourceServiceImpl implements ResourceService{
        @Autowired
        private ResourceRepository resourceRepository;

        @Override
        public ResourceResponseDto getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
            Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                    : Sort.by(sortBy).descending();
            Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
            Page<Resource> resources =  resourceRepository.findAll(pageable);
            List<Resource> resourceList =resources.getContent();
            ResourceResponseDto resourceResponseDto = new ResourceResponseDto();
            resourceResponseDto.setPage(resources.getNumber());
            resourceResponseDto.setTotal_pages(resources.getTotalPages());
            resourceResponseDto.setPer_page(resources.getSize());
            resourceResponseDto.setTotal(resources.getTotalElements());
            resourceResponseDto.setData(resourceList);
            resourceResponseDto.setSupport(getSupportData());
            return resourceResponseDto;
        }

        @Override
        public ResourceByIdDto getById(Long id) {
            resourceRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException());
            ResourceByIdDto resourceByIdDto = new ResourceByIdDto();
            resourceByIdDto.setData( resourceRepository.findById(id).get());
            resourceByIdDto.setSupport(getSupportData());
            return resourceByIdDto;
        }

        @Override
        public HttpStatus create(List<Resource> resources) {
            resources.forEach(resource->resourceRepository.save(resource));
            return HttpStatus.OK;
        }
        public SupportDto getSupportData(){
            SupportDto supportData = new SupportDto();
            supportData.setUrl("https://reqres.in/#support-heading");
            supportData.setText("To keep ReqRes free, contributions towards server costs are appreciated!");
            return supportData;
        }

    }
