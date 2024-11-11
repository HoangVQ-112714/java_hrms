package demo.hrms.service;

import demo.hrms.domain.Task;
import demo.hrms.domain.TaskPriority;
import demo.hrms.domain.TaskStatus;
import demo.hrms.domain.TaskType;
import demo.hrms.repository.TaskPriorityRepository;
import demo.hrms.repository.TaskRepository;
import demo.hrms.repository.TaskStatusRepository;
import demo.hrms.repository.TaskTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskStatusRepository taskStatusRepository;
    private final TaskPriorityRepository taskPriorityRepository;
    private final TaskTypeRepository taskTypeRepository;

    public TaskService(TaskRepository taskRepository, TaskStatusRepository taskStatusRepository, TaskPriorityRepository taskPriorityRepository, TaskTypeRepository taskTypeRepository) {
        this.taskRepository = taskRepository;
        this.taskStatusRepository = taskStatusRepository;
        this.taskPriorityRepository = taskPriorityRepository;
        this.taskTypeRepository = taskTypeRepository;
    }

    //task
    public Task addNewTask(Task task) {
        return this.taskRepository.save(task);
    }

    public List<Task> listAllTasks() {
        return this.taskRepository.findAll();
    }

    //task-status
    public List<TaskStatus> listAllTaskStatus() {
        return this.taskStatusRepository.findAll();
    }

    public TaskStatus getTaskStatusByName(String task_status_name) {
        return this.taskStatusRepository.findIdByStatus(task_status_name);
    }

    //task-priority
    public List<TaskPriority> listAllTaskPriority() {
        return this.taskPriorityRepository.findAll();
    }

    public TaskPriority getTaskPriorityByName(String task_priority_name) {
        return this.taskPriorityRepository.findByPriority(task_priority_name);
    }

    //task-type
    public List<TaskType> listAllTaskType() {
        return this.taskTypeRepository.findAll();
    }
}
