package com.UserAndResource.service;

import com.UserAndResource.dto.UserByIdDto;
import com.UserAndResource.dto.SupportDto;
import com.UserAndResource.dto.UserResponseDto;
import com.UserAndResource.exception.UserNotFoundException;
import com.UserAndResource.model.User;
import com.UserAndResource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<User> users =  userRepository.findAll(pageable);
        List<User> listOfUsers =users.getContent();
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setPage(users.getNumber());
        userResponseDto.setTotal_pages(users.getTotalPages());
        userResponseDto.setPer_page(users.getSize());
        userResponseDto.setTotal(users.getTotalElements());
        userResponseDto.setData(listOfUsers);
        userResponseDto.setSupport(getSupportData());
        return userResponseDto;
    }

    @Override
    public UserByIdDto getById(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
            UserByIdDto userByIdDto = new UserByIdDto();
            userByIdDto.setData( userRepository.findById(id).get());
            userByIdDto.setSupport(getSupportData());
            return userByIdDto;
    }

    @Override
    public HttpStatus create(List<User> users) {
        users.forEach(user->userRepository.save(user));
        return HttpStatus.OK;
    }

    public SupportDto getSupportData(){
        SupportDto supportData = new SupportDto();
        supportData.setUrl("https://reqres.in/#support-heading");
        supportData.setText("To keep ReqRes free, contributions towards server costs are appreciated!");
        return supportData;
    }

}
