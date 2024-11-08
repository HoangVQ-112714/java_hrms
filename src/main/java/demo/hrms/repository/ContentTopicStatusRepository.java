package demo.hrms.repository;

import demo.hrms.domain.ContentTopicStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentTopicStatusRepository extends JpaRepository<ContentTopicStatus, Long> {
    ContentTopicStatus findIdByName(String name);
}
