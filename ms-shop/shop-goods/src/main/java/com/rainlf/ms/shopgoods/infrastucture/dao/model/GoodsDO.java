package com.rainlf.ms.shopgoods.infrastucture.dao.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : rain
 * @date : 2021/1/27 18:52
 */
@Data
@Entity
@Table(name = "shop_goods")
public class GoodsDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer inventory;
    private Integer sellCount;
}
