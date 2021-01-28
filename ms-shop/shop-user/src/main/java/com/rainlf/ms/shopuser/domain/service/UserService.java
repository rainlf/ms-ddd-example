package com.rainlf.ms.shopuser.domain.service;


import com.rainlf.ms.shopuser.domain.entity.User;

/**
 * @author : rain
 * @date : 2021/1/27 15:32
 */
public interface UserService {
    void register(String username, String password);

    User login(String username, String password);

    User findById(Integer id);
}
