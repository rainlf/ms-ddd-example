package com.rainlf.ms.shoporder.domain.service.impl;

import com.rainlf.ms.shoporder.domain.gateway.PaymentService;
import com.rainlf.ms.shoporder.domain.entity.Order;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Detail;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Status;
import com.rainlf.ms.shoporder.domain.repository.OrderRepository;
import com.rainlf.ms.shoporder.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 18:12
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentService paymentService;

    @Override
    public void createOrder(Integer userId, List<Detail> detailList) {
        Order order = new Order(userId, detailList);
        orderRepository.saveOrder(order);
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Boolean payForOrder(Order order) {
        Boolean success = paymentService.pay();
        order.setStatus(success ? Status.SUCCESS : Status.FAILED);
        orderRepository.saveOrder(order);
        return success;
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id);
    }
}
