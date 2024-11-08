package demo.hrms.repository;

import demo.hrms.domain.ContentTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContentTopicRepository extends JpaRepository<ContentTopic, Long> {
    ContentTopic save(ContentTopic contentTopic);

    List<ContentTopic> findAll();

    List<ContentTopic> findContentTopicByProjectId(@Param("projectId") Long projectId);

    ContentTopic findContentTopicById(@Param("id") Long id);

//    @Transactional
//    @Modifying
//    @Query("SELECT DISTINCT ct FROM ContentTopic ct WHERE ct.project.id = :projectId")
//    List<Long> findContentTopicByProjectId(@Param("projectId") Long projectId);

    ContentTopic deleteById(long id);
}
