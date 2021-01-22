package com.rainlf.monolithshop.application.scheduler;

import com.google.common.collect.Lists;
import com.rainlf.monolithshop.application.service.GoodsAppService;
import com.rainlf.monolithshop.domain.goods.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/28 16:22
 */
@Component
public class GoodsInitialization implements CommandLineRunner {
    @Autowired
    private GoodsAppService goodsAppService;

    @Override
    public void run(String... args) throws Exception {
        List<Goods> goodsList = Lists.newArrayList(
                new Goods("goods-1", 11.11, 10),
                new Goods("goods-2", 22.22, 20),
                new Goods("goods-3", 33.33, 30)
        );
        goodsAppService.saveGods(goodsList);
    }
}
