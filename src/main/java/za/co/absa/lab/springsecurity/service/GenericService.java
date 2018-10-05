package za.co.absa.lab.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.absa.lab.springsecurity.domain.RandomCity;
import za.co.absa.lab.springsecurity.domain.User;
import za.co.absa.lab.springsecurity.repo.RandomCityRepository;
import za.co.absa.lab.springsecurity.repo.UserRepository;

import java.util.List;

@Service
public class GenericService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RandomCityRepository randomCityRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    public List<RandomCity> findAllRandomCities() {
        return (List<RandomCity>)randomCityRepository.findAll();
    }
}
