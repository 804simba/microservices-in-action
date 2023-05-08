package com.simba.userservice.service;

import com.simba.userservice.VO.ResponseTemplateVO;
import com.simba.userservice.entity.User;

public interface UserService {
    User saveUser(User user);

    ResponseTemplateVO getUserByDepartment(Long userId);
}
