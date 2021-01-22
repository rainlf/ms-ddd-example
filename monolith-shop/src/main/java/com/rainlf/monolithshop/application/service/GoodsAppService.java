package com.rainlf.monolithshop.application.service;

import com.rainlf.monolithshop.domain.goods.model.Goods;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 19:48
 */
public interface GoodsAppService {
    List<Goods> findGoods();

    void saveGods(List<Goods> goodsList);
}
