package com.simba.userservice.controller;

import com.simba.userservice.VO.ResponseTemplateVO;
import com.simba.userservice.entity.User;
import com.simba.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside the save user by id of the User controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserByDepartment(@PathVariable("id") Long userId) {
        log.info("Inside the get user by id and department of the user controller");
        return userService.getUserByDepartment(userId);
    }
}
