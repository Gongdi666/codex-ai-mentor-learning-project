package com.example.devsupport.user.dto.request;

public record UserCreateRequest(
        String email,
        String password,
        String displayName) {
}
