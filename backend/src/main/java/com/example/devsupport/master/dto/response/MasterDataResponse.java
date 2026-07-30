package com.example.devsupport.master.dto.response;

import java.util.List;

public record MasterDataResponse(
        List<ProjectRoleResponse> projectRoles,
        List<TaskStatusResponse> taskStatuses,
        List<TaskPriorityResponse> taskPriorities) {
}
