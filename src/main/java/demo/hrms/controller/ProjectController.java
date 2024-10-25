package demo.hrms.controller;

import demo.hrms.domain.Project;
import demo.hrms.service.ProjectService;
import demo.hrms.service.UploadService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProjectController {
    public final ProjectService projectService;
    private final UploadService uploadService;

    public ProjectController(ProjectService projectService, UploadService uploadService) {
        this.projectService = projectService;
        this.uploadService = uploadService;
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
        if (avatar == null) {
            project.setImage("project-default-1.jpg");
        }
        project.setImage(avatar);

        return "redirect:/project/list";
    }

    //project - chi tiết

    //project - chỉnh sửa

    //project - xoá
    @RequestMapping("/project/{id}/delete")
    public String deleteProject(@PathVariable int id) {
        Project project = this.projectService.loadProjectById(id);
        if (project != null) {
            this.projectService.deleteProject(id);
        }
        return "redirect:/project/list";
    }
}
