package com.example.devsupport.project.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devsupport.project.entity.Project;
import com.example.devsupport.project.entity.ProjectInvitation;
import com.example.devsupport.project.enums.ProjectInvitationStatus;

public interface ProjectInvitationRepository extends JpaRepository<ProjectInvitation, Long> {
    Optional<ProjectInvitation> findByToken(String token);
    List<ProjectInvitation> findByEmail(String email);
    List<ProjectInvitation> findByProject(Project project);
    List<ProjectInvitation> findByStatus(ProjectInvitationStatus status);
    List<ProjectInvitation> findByStatusAndExpiresAtBefore(ProjectInvitationStatus status, LocalDateTime now);
    boolean existsByProjectAndEmailAndStatus(Project project, String email, ProjectInvitationStatus status);
}
