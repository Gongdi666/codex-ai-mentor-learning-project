package com.example.devsupport.project.repository;

import com.example.devsupport.project.entity.Project;
import com.example.devsupport.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ProjectRepository  extends JpaRepository<Project, Long> {
    Optional<Project> findByIdAndDeletedAtIsNull(Long id);
    List<Project> findAllByDeletedAtIsNull();
    List<Project> findByCreatedByAndDeletedAtIsNull(User createdBy);
}
