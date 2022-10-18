package com.UserAndResource.dto;

import com.UserAndResource.model.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceResponseDto {
    private int page;
    private int per_page;
    private Long total;
    private int total_pages;
    private List<Resource> data;
    private SupportDto support;
}
