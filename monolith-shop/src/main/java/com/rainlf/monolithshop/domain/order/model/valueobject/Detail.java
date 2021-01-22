package com.rainlf.monolithshop.domain.order.model.valueobject;

import lombok.Data;
import lombok.Value;

/**
 * @author : rain
 * @date : 2021/1/27 18:08
 */
@Data
public class Detail {
    private Integer goodsId;
    private String goodsName;
    private Double goodsPrice;
    private Integer goodsNumber;

    public Detail() {
    }

    public Detail(Integer goodsId, String goodsName, Double goodsPrice, Integer goodsNumber) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNumber = goodsNumber;
    }
}
