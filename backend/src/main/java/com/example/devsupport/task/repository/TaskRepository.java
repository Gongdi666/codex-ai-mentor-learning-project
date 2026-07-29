package com.example.devsupport.task.repository;

import com.example.devsupport.master.entity.TaskStatus;
import com.example.devsupport.project.entity.Project;
import com.example.devsupport.task.entity.Task;
import com.example.devsupport.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByProjectAndDeletedAtIsNull(Project project);
    List<Task> findAllByProjectAndStatusAndDeletedAtIsNull(Project project, TaskStatus status);
    Optional<Task> findByIdAndProjectAndDeletedAtIsNull(Long id, Project project);
    List<Task> findByAssigneeAndDeletedAtIsNull(User assignee);
}
