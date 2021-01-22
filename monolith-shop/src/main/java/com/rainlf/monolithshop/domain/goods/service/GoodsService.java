package com.rainlf.monolithshop.domain.goods.service;

import com.rainlf.monolithshop.domain.goods.model.Goods;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 15:54
 */
public interface GoodsService {

    List<Goods> findGoods();

    void addInventory(Integer goodsId, Integer inventory);

    void subtractInventory(Integer goodsId, Integer inventory);

    void saveGoods(List<Goods> goodsList);

    void addSellCount(Integer goodsId);
}
