package com.example.devsupport.master.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsupport.master.dto.response.MasterDataResponse;
import com.example.devsupport.master.dto.response.ProjectRoleResponse;
import com.example.devsupport.master.dto.response.TaskPriorityResponse;
import com.example.devsupport.master.dto.response.TaskStatusResponse;
import com.example.devsupport.master.entity.ProjectRole;
import com.example.devsupport.master.entity.TaskPriority;
import com.example.devsupport.master.entity.TaskStatus;
import com.example.devsupport.master.repository.ProjectRoleRepository;
import com.example.devsupport.master.repository.TaskPriorityRepository;
import com.example.devsupport.master.repository.TaskStatusRepository;

@Service
@Transactional(readOnly = true) // このServiceの処理が読み取り専用になるアノテーション
public class MasterDataService {
    private final ProjectRoleRepository projectRoleRepository; // コンストラクタで受け取る各Repositoryのフィールド
    private final TaskStatusRepository taskStatusRepository;
    private final TaskPriorityRepository taskPriorityRepository;

    public MasterDataService( // コンストラクタで各Repositoryを受け取る
            ProjectRoleRepository projectRoleRepository,
            TaskStatusRepository taskStatusRepository,
            TaskPriorityRepository taskPriorityRepository) {
        this.projectRoleRepository = projectRoleRepository;
        this.taskStatusRepository = taskStatusRepository;
        this.taskPriorityRepository = taskPriorityRepository;
    }

    // 固定マスタ一式を取得するServiceメソッド
    public MasterDataResponse getMasterData() {
        // idで昇順に並び替えた後EntityをDTOに変換
        List<ProjectRoleResponse> projectRoles = projectRoleRepository.findAllByOrderByIdAsc().stream()
                .map(this::toProjectRoleResponse)
                .toList();

        // sortOrderで昇順に並び替えた後EntityをDTOに変換
        List<TaskStatusResponse> taskStatuses = taskStatusRepository.findAllByOrderBySortOrderAsc().stream()
                .map(this::toTaskStatusResponse)
                .toList();

        List<TaskPriorityResponse> taskPriorities = taskPriorityRepository.findAllByOrderBySortOrderAsc().stream()
                .map(this::toTaskPriorityResponse)
                .toList();

        // MasterDataResponseのコンストラクタに値を渡して返す
        return new MasterDataResponse(projectRoles, taskStatuses, taskPriorities);
    }

    // 各EntityをDTOに変換
    private ProjectRoleResponse toProjectRoleResponse(ProjectRole projectRole) {
        return new ProjectRoleResponse(
                projectRole.getId(),
                projectRole.getCode(),
                projectRole.getName());
    }

    private TaskStatusResponse toTaskStatusResponse(TaskStatus taskStatus) {
        return new TaskStatusResponse(
                taskStatus.getId(),
                taskStatus.getCode(),
                taskStatus.getName(),
                taskStatus.getSortOrder());
    }

    private TaskPriorityResponse toTaskPriorityResponse(TaskPriority taskPriority) {
        return new TaskPriorityResponse(
                taskPriority.getId(),
                taskPriority.getCode(),
                taskPriority.getName(),
                taskPriority.getSortOrder());
    }
}
