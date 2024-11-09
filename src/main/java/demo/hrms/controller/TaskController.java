package demo.hrms.controller;

import demo.hrms.domain.Task;
import demo.hrms.domain.TaskPriority;
import demo.hrms.domain.TaskStatus;
import demo.hrms.domain.User;
import demo.hrms.service.ProjectService;
import demo.hrms.service.TaskService;
import demo.hrms.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    /**********************
     * Quản lý công việc
     **********************/
    //project - danh sách
    @GetMapping("/task/list")
    public String projectList(Model model) {
        List<Task> arrTask = this.taskService.listAllTasks();
        model.addAttribute("tasks", arrTask);
        return "task/task-list";
    }

    //project - tạo mới
    @GetMapping("/task/create")
    public String createTask(Model model) {
        model.addAttribute("newTask", new Task());

        List<User> arrUser = this.userService.listAllUser();
        model.addAttribute("arrUser", arrUser);

        List<TaskStatus> arrTaskStatus = this.taskService.listAllTaskStatus();
        model.addAttribute("arrTaskStatus", arrTaskStatus);

        List<TaskPriority> arrTaskPriority = this.taskService.listAllTaskPriority();
        model.addAttribute("arrTaskPriority", arrTaskPriority);

        return "task/task-create";
    }

    @PostMapping(value = "/task/create/post")
    public String createProjectPost(@ModelAttribute("newTask") @Valid Task task,
                                    BindingResult newProjectBindingResult) {
        if (newProjectBindingResult.hasErrors()) {
            return "task/task-create";
        }

        this.taskService.addNewTask(task);

        return "redirect:/task/list";
    }
}
