package com.example.devsupport.master.dto.response;

public record TaskStatusResponse(
        Long id,
        String code,
        String name,
        Integer sortOrder) {
}
