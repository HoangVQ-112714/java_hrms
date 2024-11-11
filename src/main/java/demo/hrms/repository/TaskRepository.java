package demo.hrms.repository;

import demo.hrms.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task save(Task task);

    List<Task> findAll();

    Task findById(long task_id);

//    @Transactional
//    @Modifying
//    @Query("SELECT DISTINCT pu.user.id FROM Task pu WHERE pu.task.id = :taskId")
//    List<Long> findUserIdsByProjectId(@Param("projectId") Long projectId);
}
