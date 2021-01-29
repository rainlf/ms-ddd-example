package com.rainlf.ms.shopgoods.domain.service.impl;

import com.google.common.collect.Lists;
import com.rainlf.ms.shopgoods.domain.entity.Goods;
import com.rainlf.ms.shopgoods.domain.repository.GoodsRepository;
import com.rainlf.ms.shopgoods.domain.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 15:55
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public List<Goods> findGoods() {
        return goodsRepository.findGoods();
    }

    @Override
    @Transactional
    public void addInventory(Integer goodsId, Integer inventory) {
        goodsRepository.addInventory(goodsId, inventory);
    }

    @Override
    @Transactional
    public void subtractInventory(Integer goodsId, Integer inventory) {
        goodsRepository.subtractInventory(goodsId, inventory);
        Goods goods = goodsRepository.findById(goodsId);
        if (goods.getInventory() < 0) {
            throw new RuntimeException("over sold, roll back transaction");
        }
    }

    @Override
    public void saveGoods(List<Goods> goodsList) {
        goodsRepository.saveGoods(goodsList);
    }

    @Override
    public void addSellCount(Integer goodsId) {
        Goods goods = goodsRepository.findById(goodsId);
        goods.setSellCount(goods.getSellCount() + 1);
        goodsRepository.saveGoods(Lists.newArrayList(goods));
    }
}
