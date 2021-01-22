package com.rainlf.monolithshop.domain.order.service.impl;

import com.rainlf.monolithshop.domain.order.facade.PaymentService;
import com.rainlf.monolithshop.domain.order.model.Order;
import com.rainlf.monolithshop.domain.order.model.valueobject.Detail;
import com.rainlf.monolithshop.domain.order.model.valueobject.Status;
import com.rainlf.monolithshop.domain.order.repository.OrderRepository;
import com.rainlf.monolithshop.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
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
