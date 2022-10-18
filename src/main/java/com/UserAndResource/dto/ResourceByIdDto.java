package com.UserAndResource.dto;

import com.UserAndResource.model.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceByIdDto {
    private Resource data;
    private SupportDto support;
}
