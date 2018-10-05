package za.co.absa.lab.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.absa.lab.springsecurity.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
