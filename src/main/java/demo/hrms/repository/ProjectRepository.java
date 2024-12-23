package demo.hrms.repository;

import demo.hrms.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project save(Project project);

    List<Project> findAll();

    Project findById(long project_id);

    Project deleteById(long project_id);
}
