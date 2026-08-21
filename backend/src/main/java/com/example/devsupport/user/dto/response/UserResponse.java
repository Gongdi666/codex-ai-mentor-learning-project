package com.example.devsupport.user.dto.response;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        String displayName,
        String systemRoleCode,
        String systemRoleName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}