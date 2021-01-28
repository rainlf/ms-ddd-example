package com.rainlf.ms.shopgoods.domain.model;

import lombok.Data;

/**
 * @author : rain
 * @date : 2021/1/27 15:49
 */
@Data
public class Goods {
    private Integer id;
    private String name;
    private Double price;
    private Integer inventory;
    private Integer sellCount;

    public Goods() {
    }

    public Goods(String name, Double price, Integer inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.sellCount = 0;
    }
}
