package com.example.devsupport.project.repository;

import com.example.devsupport.project.entity.Project;
import com.example.devsupport.project.entity.ProjectMember;
import com.example.devsupport.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
    List<ProjectMember> findByProjectAndDeletedAtIsNull(Project project);
    List<ProjectMember> findByUserAndDeletedAtIsNull(User user);
    Optional<ProjectMember> findByProjectAndUserAndDeletedAtIsNull(Project project, User user);
    Long countByProjectAndProjectRole_CodeAndDeletedAtIsNull(Project project, String projectRoleCode);
    boolean existsByProjectAndUser(Project project, User user);
}
