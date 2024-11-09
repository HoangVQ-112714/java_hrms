package demo.hrms.repository;

import demo.hrms.domain.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long> {
    List<TaskPriority> findAll();

    TaskPriority findByPriority(String priority);
}
