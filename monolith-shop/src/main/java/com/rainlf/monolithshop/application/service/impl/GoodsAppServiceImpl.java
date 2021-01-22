package com.rainlf.monolithshop.application.service.impl;

import com.rainlf.monolithshop.application.service.GoodsAppService;
import com.rainlf.monolithshop.domain.goods.model.Goods;
import com.rainlf.monolithshop.domain.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 19:48
 */
@Service
public class GoodsAppServiceImpl implements GoodsAppService {
    @Autowired
    private GoodsService goodsService;

    @Override
    public List<Goods> findGoods() {
        return goodsService.findGoods();
    }

    @Override
    public void saveGods(List<Goods> goodsList) {
        goodsService.saveGoods(goodsList);
    }
}
