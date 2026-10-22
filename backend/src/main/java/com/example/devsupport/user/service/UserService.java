package com.example.devsupport.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsupport.exception.ResourceNotFoundException;
import com.example.devsupport.user.repository.UserRepository;
import com.example.devsupport.user.dto.response.UserResponse;
import com.example.devsupport.user.dto.response.UserSummaryResponse;
import com.example.devsupport.user.entity.User;

@Service
@Transactional(readOnly = true) // このServiceの処理が読み取り専用になるアノテーション
public class UserService {
    private final UserRepository userRepository; // UserRepositoryをコンストラクタで受け取るフィールド

    // UserRepositoryをコンストラクタで受け取る
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository; // UserRepositoryをフィールドにセット
    }

    // ID指定で未削除ユーザーを取得し、UserResponseに変換して返す
    public UserResponse getUserById(Long id) {
        return userRepository.findByIdAndDeletedAtIsNull(id)
                .map(this::toUserResponse)
                .orElseThrow(() -> new ResourceNotFoundException("ユーザーが見つかりません。")); // ユーザーが見つからない場合のエラーハンドリング
    }

    private UserResponse toUserResponse(User user) { // User EntityをUserResponseに変換
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getDisplayName(),
                user.getSystemRole().getCode(),
                user.getSystemRole().getName(),
                user.getCreatedAt(),
                user.getUpdatedAt());
    }

    // メールアドレス指定で未削除ユーザーを取得し、UserResponseに変換して返す
    public UserResponse getUserByEmail(String email) {
        return userRepository.findByEmailAndDeletedAtIsNull(email)
                .map(this::toUserResponse)
                .orElseThrow(() -> new ResourceNotFoundException("ユーザーが見つかりません。"));
    }

    private UserSummaryResponse toUserSummaryResponse(User user) { // User EntityをUserSummaryResponseに変換
        String displayName;
        if (user.getDeletedAt() == null) {
            displayName = user.getDisplayName();
        } else {
            displayName = "削除済みユーザー";
        }
        return new UserSummaryResponse(
                user.getId(),
                displayName);
    }
}
