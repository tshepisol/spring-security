package za.co.absa.lab.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.absa.lab.springsecurity.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
