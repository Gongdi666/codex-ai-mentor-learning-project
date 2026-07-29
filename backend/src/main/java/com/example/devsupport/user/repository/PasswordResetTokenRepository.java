package com.example.devsupport.user.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devsupport.user.entity.PasswordResetToken;
import com.example.devsupport.user.entity.User;
import com.example.devsupport.user.enums.PasswordResetTokenStatus;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
    List<PasswordResetToken> findByUser(User user);
    List<PasswordResetToken> findByStatusAndExpiresAtBefore(PasswordResetTokenStatus status, LocalDateTime now);
    List<PasswordResetToken> findByUserAndStatus(User user, PasswordResetTokenStatus status);
    Optional<PasswordResetToken> findByTokenAndStatus(String token, PasswordResetTokenStatus status);
}
