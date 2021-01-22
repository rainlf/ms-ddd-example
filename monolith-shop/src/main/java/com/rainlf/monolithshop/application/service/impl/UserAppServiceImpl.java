package com.rainlf.monolithshop.application.service.impl;

import com.rainlf.monolithshop.application.service.UserAppService;
import com.rainlf.monolithshop.domain.user.entity.User;
import com.rainlf.monolithshop.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : rain
 * @date : 2021/1/27 19:28
 */
@Service
public class UserAppServiceImpl implements UserAppService {
    @Autowired
    private UserService userService;

    @Override
    public void register(String username, String password) {
        userService.register(username, password);
    }

    @Override
    public User login(String username, String password) {
        return userService.login(username, password);
    }
}
