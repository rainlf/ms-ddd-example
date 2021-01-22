package com.rainlf.monolithshop.infrastucture.inject.repository;

import com.rainlf.monolithshop.domain.goods.model.Goods;
import com.rainlf.monolithshop.domain.goods.repository.GoodsRepository;
import com.rainlf.monolithshop.infrastucture.dao.goods.factory.GoodsFactory;
import com.rainlf.monolithshop.infrastucture.dao.goods.repository.GoodsPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : rain
 * @date : 2021/1/27 18:55
 */
@Service
public class GoodsRepositoryImpl implements GoodsRepository {
    @Autowired
    private GoodsPORepository goodsPORepository;

    @Autowired
    private GoodsFactory goodsFactory;

    @Override
    public List<Goods> findGoods() {
        return goodsPORepository.findAll().stream().map(goodsFactory::createGoods).collect(Collectors.toList());
    }

    @Override
    public Goods findById(Integer id) {
        return goodsFactory.createGoods(goodsPORepository.findById(id).orElse(null));
    }

    @Override
    public void addInventory(Integer id, Integer inventory) {
        goodsPORepository.addInventory(id, inventory);
    }

    @Override
    public void subtractInventory(Integer id, Integer inventory) {
        goodsPORepository.subtractInventory(id, inventory);
    }

    @Override
    public void saveGoods(List<Goods> goodsList) {
        goodsPORepository.saveAll(goodsList.stream().map(x -> goodsFactory.createGoodsPO(x)).collect(Collectors.toList()));
    }
}
