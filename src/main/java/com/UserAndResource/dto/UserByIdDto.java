package com.UserAndResource.dto;

import com.UserAndResource.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserByIdDto {
    private User data;
    private SupportDto support;
}
