package com.rainlf.ms.shopuser.domain.repository;


import com.rainlf.ms.shopuser.domain.entity.User;

/**
 * @author : rain
 * @date : 2021/1/27 15:35
 */
public interface UserRepository {
    void saveUser(User user);

    User findByUsername(String username);

    User findById(Integer id);
}
