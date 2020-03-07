package ua.kpi.tef.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.tef.webapp.entity.User;

import java.util.Optional;

/**
 * Created by Anton Domin on 2020-03-05
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
