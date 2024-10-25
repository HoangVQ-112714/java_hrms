package demo.hrms.service;

import demo.hrms.domain.Project;
import demo.hrms.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

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
}
