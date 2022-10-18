package com.UserAndResource.dto;

import com.UserAndResource.model.User;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponseDto {
    private int page;
    private int per_page;
    private Long total;
    private int total_pages;
    private List<User> data;
    private SupportDto support;
}
