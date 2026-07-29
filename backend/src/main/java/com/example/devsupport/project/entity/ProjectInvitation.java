package com.example.devsupport.project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.devsupport.master.entity.ProjectRole;
import com.example.devsupport.project.enums.ProjectInvitationStatus;
import com.example.devsupport.user.entity.User;

@Entity
@Table(name = "project_invitations")
public class ProjectInvitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, unique = true, length = 255)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private ProjectInvitationStatus status;

    @ManyToOne
    @JoinColumn(name = "invited_by", nullable = false)
    private User invitedBy;

    @ManyToOne
    @JoinColumn(name = "initial_project_role_id", nullable = false)
    private ProjectRole initialProjectRole;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "accepted_at", nullable = true)
    private LocalDateTime acceptedAt;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    protected ProjectInvitation() {}

    public ProjectInvitation(Project project, String email, String token, ProjectInvitationStatus status, User invitedBy, ProjectRole initialProjectRole, LocalDateTime expiresAt) {
        this.project = project;
        this.email = email;
        this.token = token;
        this.status = status;
        this.invitedBy = invitedBy;
        this.initialProjectRole = initialProjectRole;
        this.expiresAt = expiresAt;
    }

    public Long getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public ProjectInvitationStatus getStatus() {
        return status;
    }

    public User getInvitedBy() {
        return invitedBy;
    }

    public ProjectRole getInitialProjectRole() {
        return initialProjectRole;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public LocalDateTime getAcceptedAt() {
        return acceptedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
