package com.rainlf.ms.shopgoods.application.service.impl;

import com.rainlf.ms.shopgoods.application.dto.User;
import com.rainlf.ms.shopgoods.application.facade.UserService;
import com.rainlf.ms.shopgoods.application.service.GoodsAppService;
import com.rainlf.ms.shopgoods.domain.model.Goods;
import com.rainlf.ms.shopgoods.domain.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 19:48
 */
@Slf4j
@Service
public class GoodsAppServiceImpl implements GoodsAppService {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @Override
    public List<Goods> findGoods(Integer userId) {
        User user = userService.findById(userId);
        log.info("{} is browsing goods", user.getUsername());
        return goodsService.findGoods();
    }

    @Override
    public void saveGods(List<Goods> goodsList) {
        goodsService.saveGoods(goodsList);
    }
}
