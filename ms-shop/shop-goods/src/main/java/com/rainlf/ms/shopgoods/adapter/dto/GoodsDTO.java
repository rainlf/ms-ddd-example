package com.rainlf.ms.shopgoods.adapter.dto;

import lombok.Data;

/**
 * @author : rain
 * @date : 2021/1/29 19:00
 */
@Data
public class GoodsDTO {
    private Integer id;
    private String name;
    private Double price;
    private Integer inventory;
}
