package demo.hrms.repository;

import demo.hrms.domain.Project;
import demo.hrms.domain.ProjectUser;
import demo.hrms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjectUserRepository extends JpaRepository<ProjectUser, Long> {
    ProjectUser save(ProjectUser projectUser);

    List<ProjectUser> findAll();

    @Transactional
    @Modifying
    @Query("SELECT DISTINCT pu.user.id FROM ProjectUser pu WHERE pu.project.id = :projectId")
    List<Long> findUserIdsByProjectId(@Param("projectId") Long projectId);

//    @Transactional
//    @Modifying
//    @Query("SELECT COUNT(pu.user.id)  FROM ProjectUser pu WHERE pu.project = :projectId")
//    void deleteByProjectId(Long projectId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProjectUser pu WHERE pu.project.id = :projectId AND pu.user.id = :userId")
    void deleteByProjectIdAndUserId(Long projectId, Long userId);
}
