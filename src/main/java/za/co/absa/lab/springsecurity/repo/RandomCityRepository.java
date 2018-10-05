package za.co.absa.lab.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.absa.lab.springsecurity.domain.RandomCity;

public interface RandomCityRepository extends JpaRepository<RandomCity, Long> {
}
