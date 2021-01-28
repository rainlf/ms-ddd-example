package com.rainlf.ms.shopuser.application;


import com.rainlf.ms.shopuser.domain.entity.User;

/**
 * @author : rain
 * @date : 2021/1/27 19:27
 */
public interface UserAppService {
    void register(String username, String password);

    User login(String username, String password);
}
