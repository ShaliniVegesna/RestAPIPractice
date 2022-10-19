package com.UserAndResource.services;

import com.UserAndResource.dto.SupportDto;
import com.UserAndResource.dto.UserByIdDto;
import com.UserAndResource.exception.UserNotFoundException;
import com.UserAndResource.model.User;
import com.UserAndResource.repository.UserRepository;
import com.UserAndResource.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    @Test
    public void testGet_All(){
        Sort sort = "asc".equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("id").ascending()
                : Sort.by("id").descending();
        Pageable pageable = PageRequest.of(1,6,sort);
        Page<User> users= Mockito.mock(Page.class);
        List<User> usersList = new ArrayList<>();
        when(userRepository.findAll(pageable)).thenReturn(users);
        when(users.getContent()).thenReturn(usersList);
        userService.getAll(1,6,"id","asc");
    }
    @Test
    public void testGet_By_Id(){
        User user = new User();
        user.setId(2L);
        user.setFirst_name("Janet");
        user.setLast_name("Weaver");
        user.setEmail("janet.weaver@reqres.in");
        user.setAvatar("https://reqres.in/img/faces/2-image.jpg");
        UserByIdDto userByIdResponse = new UserByIdDto();
        userByIdResponse.setData(user);
        userByIdResponse.setSupport(new SupportDto("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!"));
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userService.getById(2L);
        verify(userRepository,times(2)).findById(user.getId());
    }
    @Test()
    public void testCreate_User(){
        User user = new User();
        user.setId(2L);
        user.setFirst_name("Janet");
        user.setLast_name("Weaver");
        user.setEmail("janet.weaver@reqres.in");
        user.setAvatar("https://reqres.in/img/faces/2-image.jpg");
        List<User> users = new ArrayList<>();
        users.add(user);
        when(userRepository.save(user)).thenReturn(user);
        userService.create(users);
    }
}
