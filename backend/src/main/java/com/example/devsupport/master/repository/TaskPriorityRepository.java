package com.example.devsupport.master.repository;

import com.example.devsupport.master.entity.TaskPriority;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long> {
    Optional<TaskPriority> findByCode(String code);
    List<TaskPriority> findAllByOrderBySortOrderAsc();
}
