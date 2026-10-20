package com.example.devsupport.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsupport.user.repository.UserRepository;
import com.example.devsupport.user.dto.response.UserResponse;
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
        Long userId = UserRepository.class.cast(userRepository).findByIdAndDeletedAtIsNull(id)
                .map(user -> user.getId()) // ユーザーが見つかった場合はIDを取得
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id)); // ユーザーが見つからない場合は例外をスロー
        return new UserResponse( // UserResponseのコンストラクタに値を渡す
                userId,
                userRepository.findByIdAndDeletedAtIsNull(id).get().getEmail(),
                userRepository.findByIdAndDeletedAtIsNull(id).get().getDisplayName(),
                userRepository.findByIdAndDeletedAtIsNull(id).get().getSystemRole().getCode(),
                userRepository.findByIdAndDeletedAtIsNull(id).get().getSystemRole().getName(),
                userRepository.findByIdAndDeletedAtIsNull(id).get().getCreatedAt(),
                userRepository.findByIdAndDeletedAtIsNull(id).get().getUpdatedAt());
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

}
