package com.example.devsupport.user.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.flywaydb.core.internal.database.base.Database;

import com.example.devsupport.user.dto.response.UserResponse;
import com.example.devsupport.user.dto.response.UserSummaryResponse;
import com.example.devsupport.user.entity.User;
import com.example.devsupport.user.repository.UserRepository;
import com.example.devsupport.user.service.UserService;

public class UserServiceTest {
    UserRepository userRepository = mock(UserRepository.class); // UserRepositoryをモック化

    @Test // ユーザーIDでユーザーを取得するテスト
    void testGetUserById() {
        Long userId = 1L; // テスト用のユーザーID
        String email = "test@example.com"; // テスト用のメールアドレス
        String displayName = "Test User"; // テスト用の表示名
        String systemRoleCode = "ADMIN"; // テスト用のシステムロールコード
        String systemRoleName = "Administrator"; // テスト用のシステムロール名
        LocalDateTime createdAt = LocalDateTime.now(); // テスト用の作成日時
        LocalDateTime updatedAt = LocalDateTime.now(); // テスト用の更新日時

        UserService userService = new UserService(userRepository); // UserServiceのインスタンスを作成

        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(new User(
                userId,
                email,
                displayName,
                systemRoleCode,
                systemRoleName,
                createdAt,
                updatedAt))); // モック化したUserRepositoryのfindByIdメソッドの戻り値を設定

    }
}
