package com.example.devsupport.task.repository;

import com.example.devsupport.task.entity.Task;
import com.example.devsupport.task.entity.TaskComment;
import com.example.devsupport.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {
    List<TaskComment> findAllByTaskAndDeletedAtIsNull(Task task);
    Optional<TaskComment> findByIdAndTaskAndDeletedAtIsNull(Long id, Task task);
    List<TaskComment> findByUserAndDeletedAtIsNull(User user);
    List<TaskComment> findByTaskInAndDeletedAtIsNull(List<Task> tasks);
}
