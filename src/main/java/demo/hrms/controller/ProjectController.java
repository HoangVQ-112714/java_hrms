package demo.hrms.controller;

import demo.hrms.domain.*;
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

    /**********************
     * Quản lý dự án
     **********************/

    //project - danh sách
    @GetMapping("/project/list")
    public String projectList(Model model) {
        List<Project> arrProject = this.projectService.listAllProject();
        model.addAttribute("projects", arrProject);
        return "project/project-list";
    }

    //project - tạo mới
    @GetMapping("/project/create")
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
    @GetMapping("/project/{project_id}")
    public String getUserDetail(Model model, @PathVariable long project_id) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        int countUser = this.projectService.countUserInProject(project_id);
        model.addAttribute("countUser", countUser);
        int countContentTopic = this.projectService.countContentTopicInProject(project_id);
        model.addAttribute("countContentTopic", countContentTopic);
        return "project/project-detail";
    }

    //project - chỉnh sửa
    @RequestMapping("/project/{project_id}/update")
    public String updateUser(Model model, @PathVariable long project_id) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        return "project/project-update";
    }

    @PostMapping("/project/{project_id}/update/post")
    public String updateUserPost(Model model,
                                 @ModelAttribute("project") Project projectInfo,
                                 @PathVariable long project_id,
                                 @RequestParam("hrmsFile") MultipartFile file) {
        Project project = this.projectService.loadProjectById(project_id);
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
    @RequestMapping("/project/{project_id}/delete")
    public String deleteProject(@PathVariable int project_id) {
        Project project = this.projectService.loadProjectById(project_id);
        if (project != null) {
            this.projectService.deleteProject(project_id);
        }
        return "redirect:/project/list";
    }

    /**********************
     * Quản lý nhân sự dự án
     **********************/

    //project & user - tạo mới
    @GetMapping("/project/{project_id}/add_user")
    public String projectAddUser(Model model,
                                 @PathVariable long project_id) {
        List<User> users = userService.listAllUser();
        model.addAttribute("users", users);
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        return "project/project-user-add";
    }

    @PostMapping("/project/{project_id}/add_user/post")
    public String saveProjectUser(@PathVariable long project_id,
                                  @RequestParam("userId") Long userId) {
        Project project = projectService.loadProjectById(project_id);
        User user = userService.loadUserById(userId);
        projectService.addUserForProject(project, user);
        return "redirect:/project/{project_id}";
    }

    //project & user - danh sách
    @GetMapping("/project/{project_id}/list")
    public String projectListUser(Model model,
                                  @PathVariable long project_id) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        List<User> arrUserByProject = this.userService.loadUserForProject(project_id);
        model.addAttribute("usersByProject", arrUserByProject);
        return "project/project-user-list";
    }

    //project & user - xoá
    @GetMapping("/project/{project_id}/delete_user/{user_id}")
    public String projectDeleteUser(Model model,
                                    @PathVariable long project_id,
                                    @PathVariable long user_id) {
        this.projectService.deleteUserForProject(project_id, user_id);
        return "redirect:/project/{project_id}/list";
    }

    /**********************
     * Quản lý chủ đề dự án
     **********************/
    //project & content-topic - tạo mới
    @GetMapping("/project/{project_id}/add_content_topic")
    public String projectAddContentTopic(Model model,
                                         @PathVariable long project_id) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        List<User> arrUserByProject = this.userService.loadUserForProject(project_id);
        model.addAttribute("usersByProject", arrUserByProject);
        model.addAttribute("newContentTopic", new ContentTopic());
        return "content-topic/content-topic-create";
    }

    @PostMapping("/project/{project_id}/add_content_topic/post")
    public String saveProjectContentTopic(Model model,
                                          @PathVariable long project_id,
                                          @ModelAttribute("newContentTopic") @Valid ContentTopic contentTopic,
                                          BindingResult newContentTopicBindingResult,
                                          @RequestParam("hrmsFile") MultipartFile file) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);

        if (newContentTopicBindingResult.hasErrors()) {
            return "content-topic/content-topic-create";
        }

        String avatar = this.uploadService.handleSaveFileUploadFile(file, "content");
        if (Objects.equals(avatar, "")) {
            avatar = "project-default-1.jpg";
        }
        contentTopic.setImage(avatar);
        contentTopic.setProject(project);
        contentTopic.setContentTopicStatus(this.projectService.getContentTopicStatusByName(contentTopic.getContentTopicStatus().getName()));
        this.projectService.addNewContentTopic(contentTopic);
        return "redirect:/project/{project_id}";
    }

    //project & content-topic - danh sách
    @GetMapping("/project/{project_id}/content_topic/list")
    public String contentTopicList(Model model,
                                   @PathVariable long project_id) {
        List<ContentTopic> arrContentTopic = this.projectService.listAllContentTopicByProject(project_id);
        model.addAttribute("contentTopics", arrContentTopic);
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        return "content-topic/content-topic-list";
    }

    //project & content-topic - chi tiết
    @GetMapping("/project/{project_id}/content_topic/{content_topic_id}/detail")
    public String getContentTopicDetail(Model model,
                                        @PathVariable long project_id,
                                        @PathVariable long content_topic_id) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        ContentTopic contentTopic = this.projectService.loadContentTopicById(content_topic_id);
        model.addAttribute("contentTopic", contentTopic);
        return "content-topic/content-topic-detail";
    }

    //project & content-topic - chỉnh sửa
    @RequestMapping("/project/{project_id}/content_topic/{content_topic_id}/update")
    public String updateContentTopic(Model model,
                                     @PathVariable long project_id,
                                     @PathVariable long content_topic_id) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        ContentTopic contentTopic = this.projectService.loadContentTopicById(content_topic_id);
        model.addAttribute("contentTopic", contentTopic);
        List<ContentTopicStatus> arrContentTopicStatus = this.projectService.listAllContentTopicStatus();
        model.addAttribute("arrContentTopicStatus", arrContentTopicStatus);
        return "content-topic/content-topic-update";
    }

    @PostMapping("/project/{project_id}/content_topic/{content_topic_id}/update/post")
    public String updateContentTopicPost(Model model,
                                         @ModelAttribute("contentTopic") ContentTopic contentTopicInfo,
                                         @PathVariable long project_id,
                                         @RequestParam("hrmsFile") MultipartFile file) {
        ContentTopic contentTopic = this.projectService.loadContentTopicById(contentTopicInfo.getId());
        if (contentTopic != null) {
            contentTopic.setName(contentTopicInfo.getName());
            contentTopic.setDescription(contentTopicInfo.getDescription());
            contentTopic.setUrl_1(contentTopicInfo.getUrl_1());
            contentTopic.setUrl_2(contentTopicInfo.getUrl_2());
            contentTopic.setUrl_3(contentTopicInfo.getUrl_3());
            contentTopic.setContentTopicStatus(this.projectService.getContentTopicStatusByName(contentTopicInfo.getContentTopicStatus().getName()));
            String avatar = this.uploadService.handleSaveFileUploadFile(file, "content");
            if (avatar != "") {
                contentTopic.setImage(avatar);
            }
            this.projectService.addNewContentTopic(contentTopic);
        }
        return "redirect:/project/{project_id}/content_topic/list";
    }

    //project & content-topic - xoá
    @RequestMapping("/project/{project_id}/content_topic/{content_topic_id}/delete")
    public String deleteContentTopic(@PathVariable long content_topic_id) {
        ContentTopic contentTopic = this.projectService.loadContentTopicById(content_topic_id);
        if (contentTopic != null) {
            this.projectService.deleteContentTopic(content_topic_id);
        }
        return "redirect:/project/{project_id}/content_topic/list";
    }

    /**********************
     * Quản lý tập
     **********************/
    @GetMapping("/project/{project_id}/add_content_section")
    public String projectAddContentSection(Model model,
                                         @PathVariable long project_id) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);
        List<User> arrUserByProject = this.userService.loadUserForProject(project_id);
        model.addAttribute("usersByProject", arrUserByProject);
        model.addAttribute("newContentTopic", new ContentTopic());
        return "content-topic/content-topic-create";
    }

    @PostMapping("/project/{project_id}/add_content_section/post")
    public String saveProjectContentSection(Model model,
                                          @PathVariable long project_id,
                                          @ModelAttribute("newContentTopic") @Valid ContentTopic contentTopic,
                                          BindingResult newContentTopicBindingResult,
                                          @RequestParam("hrmsFile") MultipartFile file) {
        Project project = this.projectService.loadProjectById(project_id);
        model.addAttribute("project", project);

        if (newContentTopicBindingResult.hasErrors()) {
            return "content-topic/content-topic-create";
        }

        String avatar = this.uploadService.handleSaveFileUploadFile(file, "content");
        if (Objects.equals(avatar, "")) {
            avatar = "project-default-1.jpg";
        }
        contentTopic.setImage(avatar);
        contentTopic.setProject(project);
        contentTopic.setContentTopicStatus(this.projectService.getContentTopicStatusByName(contentTopic.getContentTopicStatus().getName()));
        this.projectService.addNewContentTopic(contentTopic);
        return "redirect:/project/{project_id}";
    }

}
