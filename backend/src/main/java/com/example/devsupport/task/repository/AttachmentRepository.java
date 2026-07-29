package com.example.devsupport.task.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devsupport.task.entity.Attachment;
import com.example.devsupport.task.entity.Task;
import com.example.devsupport.user.entity.User;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    List<Attachment> findAllByTaskAndDeletedAtIsNull(Task task);
    Optional<Attachment> findByIdAndTaskAndDeletedAtIsNull(Long id, Task task);
    List<Attachment> findByUploadedByAndDeletedAtIsNull(User uploadedBy);
    List<Attachment> findByTaskInAndDeletedAtIsNull(List<Task> tasks);
}