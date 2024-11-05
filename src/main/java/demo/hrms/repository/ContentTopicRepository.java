package demo.hrms.repository;

import demo.hrms.domain.ContentTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentTopicRepository extends JpaRepository<ContentTopic, Long> {
    ContentTopic save(ContentTopic contentTopic);

    List<ContentTopic> findAll();

    ContentTopic findById(long id);

    ContentTopic deleteById(long id);
}
