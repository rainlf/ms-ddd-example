package com.rainlf.ms.shopgoods.infrastucture.repositoryimpl;

import com.rainlf.ms.shopgoods.domain.entity.Goods;
import com.rainlf.ms.shopgoods.domain.repository.GoodsRepository;
import com.rainlf.ms.shopgoods.infrastucture.dao.convertor.GoodsConvertor;
import com.rainlf.ms.shopgoods.infrastucture.dao.repository.GoodsDORepository;
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
    private GoodsDORepository goodsDORepository;

    @Autowired
    private GoodsConvertor goodsConvertor;

    @Override
    public List<Goods> findGoods() {
        return goodsDORepository.findAll().stream().map(goodsConvertor::createGoods).collect(Collectors.toList());
    }

    @Override
    public Goods findById(Integer id) {
        return goodsConvertor.createGoods(goodsDORepository.findById(id).orElse(null));
    }

    @Override
    public void addInventory(Integer id, Integer inventory) {
        goodsDORepository.addInventory(id, inventory);
    }

    @Override
    public void subtractInventory(Integer id, Integer inventory) {
        goodsDORepository.subtractInventory(id, inventory);
    }

    @Override
    public void saveGoods(List<Goods> goodsList) {
        goodsDORepository.saveAll(goodsList.stream().map(x -> goodsConvertor.createGoodsPO(x)).collect(Collectors.toList()));
    }
}
