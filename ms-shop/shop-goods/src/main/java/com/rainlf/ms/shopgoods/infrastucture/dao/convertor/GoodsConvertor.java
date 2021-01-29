package com.rainlf.ms.shopgoods.infrastucture.dao.convertor;

import com.rainlf.ms.shopgoods.domain.entity.Goods;
import com.rainlf.ms.shopgoods.infrastucture.dao.model.GoodsDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/27 18:54
 */
@Component
public class GoodsConvertor {
    public Goods createGoods(GoodsDO goodsDO) {
        if (goodsDO == null) {
            return null;
        }
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDO, goods);
        return goods;
    }

    public GoodsDO createGoodsPO(Goods goods) {
        if (goods == null) {
            return null;
        }
        GoodsDO goodsDO = new GoodsDO();
        BeanUtils.copyProperties(goods, goodsDO);
        return goodsDO;
    }
}
