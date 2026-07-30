package com.example.devsupport.master.dto.response;

public record TaskPriorityResponse(
        Long id,
        String code,
        String name,
        Integer sortOrder) {
}