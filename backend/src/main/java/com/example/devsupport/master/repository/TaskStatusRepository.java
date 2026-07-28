package com.example.devsupport.master.repository;

import com.example.devsupport.master.entity.TaskStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
    Optional<TaskStatus> findByCode(String code);
    List<TaskStatus> findAllByOrderBySortOrderAsc();
}
