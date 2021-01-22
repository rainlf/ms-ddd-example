package com.rainlf.monolithshop.infrastucture.dao.goods.factory;

import com.rainlf.monolithshop.domain.goods.model.Goods;
import com.rainlf.monolithshop.infrastucture.dao.goods.entity.GoodsPO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
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
