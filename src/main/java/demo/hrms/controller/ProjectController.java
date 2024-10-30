package demo.hrms.controller;

import demo.hrms.domain.Project;
import demo.hrms.domain.User;
import demo.hrms.service.ProjectService;
import demo.hrms.service.UploadService;
import demo.hrms.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Controller
public class ProjectController {
    public final ProjectService projectService;
    private final UploadService uploadService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UploadService uploadService, UserService userService) {
        this.projectService = projectService;
        this.uploadService = uploadService;
        this.userService = userService;
    }

    //project - danh sách
    @GetMapping("project/list")
    public String projectList(Model model) {
        List<Project> arrProject = this.projectService.listAllProject();
        model.addAttribute("projects", arrProject);
        return "project/project-list";
    }

    //project - tạo mới
    @GetMapping("project/create")
    public String createProject(Model model) {
        model.addAttribute("newProject", new Project());
        return "project/project-create";
    }

    @PostMapping(value = "/project/list")
    public String createProjectPost(@ModelAttribute("newProject") @Valid Project project,
                                    BindingResult newProjectBindingResult,
                                    @RequestParam("hrmsFile") MultipartFile file) {
        if (newProjectBindingResult.hasErrors()) {
            return "project/project-create";
        }

        String avatar = this.uploadService.handleSaveFileUploadFile(file, "project");
        if (Objects.equals(avatar, "")) {
            avatar = "project-default-1.jpg";
        }
        project.setImage(avatar);
        this.projectService.addNewProject(project);

        return "redirect:/project/list";
    }

    //project - chi tiết
    @GetMapping("/project/{id}")
    public String getUserDetail(Model model, @PathVariable long id) {
        Project project = this.projectService.loadProjectById(id);
        model.addAttribute("project", project);
        return "project/project-detail";
    }

    //project - chỉnh sửa
    @RequestMapping("/project/{id}/update")
    public String updateUser(Model model, @PathVariable long id) {
        Project project = this.projectService.loadProjectById(id);
        model.addAttribute("project", project);
        return "project/project-update";
    }

    @PostMapping("/project/{id}")
    public String updateUserPost(Model model,
                                 @ModelAttribute("project") Project projectInfo,
                                 @PathVariable long id,
                                 @RequestParam("hrmsFile") MultipartFile file) {
        Project project = this.projectService.loadProjectById(projectInfo.getId());
        if (project != null) {
            project.setName(projectInfo.getName());
            project.setDescription(projectInfo.getDescription());
            project.setType(projectInfo.getType());
            String avatar = this.uploadService.handleSaveFileUploadFile(file, "project");
            if (avatar != "") {
                project.setImage(avatar);
            }
            this.projectService.addNewProject(project);
        }
        return "redirect:/project/list";
    }

    //project - xoá
    @RequestMapping("/project/{id}/delete")
    public String deleteProject(@PathVariable int id) {
        Project project = this.projectService.loadProjectById(id);
        if (project != null) {
            this.projectService.deleteProject(id);
        }
        return "redirect:/project/list";
    }

    //project & user - tạo mới
    @GetMapping("/project/{id}/add_user")
    public String projectAddUser(Model model, @PathVariable long id) {
        model.addAttribute("newProject", new Project());
        List<User> users = userService.listAllUser();
        model.addAttribute("users", users);
        Project project = this.projectService.loadProjectById(id);
        model.addAttribute("project", project);
        return "project/project-user-add";
    }

//    @PostMapping(value = "/project_user/list")
//    public String projectAddUserPost(@ModelAttribute("newProjectUser"),
//                                    BindingResult newProjectBindingResult,
//                                    @RequestParam("hrmsFile") MultipartFile file) {
//        if (newProjectBindingResult.hasErrors()) {
//            return "project/project-create";
//        }
//
//        String avatar = this.uploadService.handleSaveFileUploadFile(file, "project");
//        if (avatar == "") {
//            avatar = "project-default-1.jpg";
//        }
//        project.setImage(avatar);
//        this.projectService.addNewProject(project);
//
//        return "redirect:/project/list";
//    }
}
