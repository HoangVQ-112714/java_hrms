package demo.hrms.service;

import demo.hrms.domain.*;
import demo.hrms.repository.ContentTopicRepository;
import demo.hrms.repository.ContentTopicStatusRepository;
import demo.hrms.repository.ProjectRepository;
import demo.hrms.repository.ProjectUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectUserRepository projectUserRepository;
    private final ContentTopicRepository contentTopicRepository;
    private final ContentTopicStatusRepository contentTopicStatusRepository;

    public ProjectService(ProjectRepository projectRepository,
                          ProjectUserRepository projectUserRepository,
                          ContentTopicRepository contentTopicRepository,
                          ContentTopicStatusRepository contentTopicStatusRepository) {
        this.projectRepository = projectRepository;
        this.projectUserRepository = projectUserRepository;
        this.contentTopicRepository = contentTopicRepository;
        this.contentTopicStatusRepository = contentTopicStatusRepository;
    }

    //project
    public Project addNewProject(Project project) {
        return this.projectRepository.save(project);
    }

    public Project deleteProject(long id) {
        return this.projectRepository.deleteById(id);
    }

    public List<Project> listAllProject() {
        return this.projectRepository.findAll();
    }

    public Project loadProjectById(long id) {
        return this.projectRepository.findById(id);
    }

    //project - user
    public void addUserForProject(Project project, User user) {
        ProjectUser projectUser = new ProjectUser();
        projectUser.setProject(project);
        projectUser.setUser(user);
        projectUserRepository.save(projectUser);
    }

    public void deleteUserForProject(Long project_id, Long user_id) {
        projectUserRepository.deleteByProjectIdAndUserId(project_id, user_id);
    }

    public int countUserInProject(Long project_id) {
        return this.projectUserRepository.findUserIdsByProjectId(project_id).size();
    }

    //project - contentTopic
    public ContentTopic addNewContentTopic(ContentTopic contentTopic) {
        return this.contentTopicRepository.save(contentTopic);
    }

    public List<ContentTopic> listAllContentTopicByProject(Long project_id) {
        return this.contentTopicRepository.findContentTopicByProjectId(project_id);
    }

    public ContentTopic loadContentTopicById(long content_topic_id) {
        return this.contentTopicRepository.findContentTopicById(content_topic_id);
    }

    public int countContentTopicInProject(Long project_id) {
        return this.contentTopicRepository.findContentTopicByProjectId(project_id).size();
    }

    public ContentTopic deleteContentTopic(long content_topic_id) {
        return this.contentTopicRepository.deleteById(content_topic_id);
    }

    public ContentTopicStatus getContentTopicStatusByName(String name) {
        return this.contentTopicStatusRepository.findIdByName(name);
    }

}
