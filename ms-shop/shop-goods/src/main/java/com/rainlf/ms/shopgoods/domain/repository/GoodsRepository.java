package com.rainlf.ms.shopgoods.domain.repository;


import com.rainlf.ms.shopgoods.domain.entity.Goods;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 15:55
 */
public interface GoodsRepository {
    List<Goods> findGoods();

    Goods findById(Integer id);

    void addInventory(Integer id, Integer inventory);

    void subtractInventory(Integer id, Integer inventory);

    void saveGoods(List<Goods> goodsList);
}
