package com.rainlf.ms.shopgoods.infrastucture.dao.factory;

import com.rainlf.ms.shopgoods.domain.model.Goods;
import com.rainlf.ms.shopgoods.infrastucture.dao.entity.GoodsPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/27 18:54
 */
@Component
public class GoodsFactory {
    public Goods createGoods(GoodsPO goodsPO) {
        if (goodsPO == null) {
            return null;
        }
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsPO, goods);
        return goods;
    }

    public GoodsPO createGoodsPO(Goods goods) {
        if (goods == null) {
            return null;
        }
        GoodsPO goodsPO = new GoodsPO();
        BeanUtils.copyProperties(goods, goodsPO);
        return goodsPO;
    }
}
