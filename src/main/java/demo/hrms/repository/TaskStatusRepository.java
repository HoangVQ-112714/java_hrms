package demo.hrms.repository;

import demo.hrms.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
    List<TaskStatus> findAll();

    TaskStatus findIdByStatus(String status);
}
