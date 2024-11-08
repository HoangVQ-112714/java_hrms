package demo.hrms.repository;

import demo.hrms.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task save(Task task);

    List<Task> findAll();

    Task findById(long task_id);
}
