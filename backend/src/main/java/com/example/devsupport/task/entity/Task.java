package com.example.devsupport.task.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import com.example.devsupport.project.entity.Project;
import com.example.devsupport.user.entity.User;
import com.example.devsupport.master.entity.TaskStatus;
import com.example.devsupport.master.entity.TaskPriority;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false, length = 255)
    private String summary;

    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "assignee_id", nullable = true)
    private User assignee;

    @Column(name = "due_date", nullable = true)
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "priority_id", nullable = false)
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "deleted_by", nullable = true)
    private User deletedBy;

    protected Task() {}

    public Task(Project project, String summary, String description, TaskStatus status, User assignee, LocalDate dueDate, TaskPriority priority, User creator) {
        this.project = project;
        this.summary = summary;
        this.description = description;
        this.status = status;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.priority = priority;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public User getAssignee() {
        return assignee;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public User getCreator() {
        return creator;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public User getDeletedBy() {
        return deletedBy;
    }
}
