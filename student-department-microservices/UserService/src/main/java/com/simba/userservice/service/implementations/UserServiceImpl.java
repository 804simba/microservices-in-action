package com.simba.userservice.service.implementations;

import com.simba.userservice.VO.Department;
import com.simba.userservice.VO.ResponseTemplateVO;
import com.simba.userservice.entity.User;
import com.simba.userservice.repository.UserRepository;
import com.simba.userservice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        log.info("Inside the save user by id of the User service");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplateVO getUserByDepartment(Long userId) {
        log.info("Inside the get user by id and department of the User service");
        ResponseTemplateVO response = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId)
                .orElseThrow(EntityNotFoundException::new);

        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + user.getUserId(),
                Department.class
        );

        response.setUser(user);
        response.setDepartment(department);

        return response;
    }
}
