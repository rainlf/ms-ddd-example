package com.rainlf.ms.shopuser.domain.entity;

import lombok.Data;

/**
 * @author : rain
 * @date : 2021/1/27 15:30
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
