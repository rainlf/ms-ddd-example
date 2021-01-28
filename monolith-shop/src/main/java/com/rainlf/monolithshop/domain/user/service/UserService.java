package com.rainlf.monolithshop.domain.user.service;

import com.rainlf.monolithshop.domain.user.entity.User;

/**
 * @author : rain
 * @date : 2021/1/27 15:32
 */
public interface UserService {
    void register(String username, String password);

    User login(String username, String password);

    User findById(Integer id);
}
