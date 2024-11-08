package demo.hrms.service;

import demo.hrms.domain.Task;
import demo.hrms.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //task
    public Task addNewTask(Task task) {
        return this.taskRepository.save(task);
    }

    public List<Task> listAllTasks() {
        return this.taskRepository.findAll();
    }
}
