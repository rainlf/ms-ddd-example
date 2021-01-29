package com.rainlf.ms.shoporder.infrastucture.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : rain
 * @date : 2021/1/27 19:04
 */
@Data
@Entity
@Table(name = "shop_order")
public class OrderPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String detailList;
    private Integer status;
    private Date createTime;
}
