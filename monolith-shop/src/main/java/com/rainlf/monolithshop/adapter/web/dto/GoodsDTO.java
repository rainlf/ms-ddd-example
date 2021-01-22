package com.rainlf.monolithshop.adapter.web.dto;

import lombok.Data;

/**
 * @author : rain
 * @date : 2021/1/27 19:46
 */
@Data
public class GoodsDTO {
    private Integer id;
    private String name;
    private Double price;
    private Integer inventory;
}
