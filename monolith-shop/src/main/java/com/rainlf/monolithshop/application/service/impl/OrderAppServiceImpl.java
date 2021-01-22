package com.rainlf.monolithshop.application.service.impl;

import com.rainlf.monolithshop.application.service.OrderAppService;
import com.rainlf.monolithshop.domain.goods.service.GoodsService;
import com.rainlf.monolithshop.domain.order.model.Order;
import com.rainlf.monolithshop.domain.order.model.valueobject.Detail;
import com.rainlf.monolithshop.domain.order.model.valueobject.Status;
import com.rainlf.monolithshop.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/**
 * @author : rain
 * @date : 2021/1/27 19:52
 */
@Service
public class OrderAppServiceImpl implements OrderAppService {
    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Override
    public void createOrder(Integer userId, List<Detail> detailList) {
        detailList.forEach(detail -> goodsService.subtractInventory(detail.getGoodsId(), detail.getGoodsNumber()));
        orderService.createOrder(userId, detailList);
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderService.findByUserId(userId);
    }

    @Override
    public void payForOrder(Integer id) {
        Order order = orderService.findById(id);
        if (order == null) {
            throw new RuntimeException(MessageFormat.format("order id not exists: {0}", id));
        }
        if (!Objects.equals(order.getStatus(), Status.CREATED)) {
            throw new RuntimeException(MessageFormat.format("order has been paid: {0}", id));
        }

        if (orderService.payForOrder(order)) {
            order.getDetailList().forEach(detail -> goodsService.addSellCount(detail.getGoodsId()));
        } else {
            order.getDetailList().forEach(detail -> goodsService.addInventory(detail.getGoodsId(), detail.getGoodsNumber()));
            throw new RuntimeException("pay failed");
        }
    }
}
