package com.rainlf.monolithshop.infrastucture.dao.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : rain
 * @date : 2021/1/27 18:59
 */
@Data
@Entity
@Table(name = "shop_user")
public class UserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
}
