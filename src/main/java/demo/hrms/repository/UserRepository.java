package demo.hrms.repository;

import demo.hrms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    List<User> findAll();

    User findById(long id);

    User deleteById(long id);

    @Query("SELECT u FROM User u WHERE u.id IN :userIds")
    List<User> findUsersByIds(@Param("userIds") List<Long> userIds);
}
