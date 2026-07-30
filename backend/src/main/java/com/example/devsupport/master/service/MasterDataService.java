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
@Transactional(readOnly = true)
public class MasterDataService {

}
