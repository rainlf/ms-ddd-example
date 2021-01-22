package com.rainlf.monolithshop.infrastucture.inject.repository;

import com.rainlf.monolithshop.domain.order.model.Order;
import com.rainlf.monolithshop.domain.order.repository.OrderRepository;
import com.rainlf.monolithshop.infrastucture.dao.order.factory.OrderFactory;
import com.rainlf.monolithshop.infrastucture.dao.order.repository.OrderPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : rain
 * @date : 2021/1/27 19:06
 */
@Service
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private OrderPORepository orderPORepository;

    @Autowired
    private OrderFactory orderFactory;

    @Override
    public void saveOrder(Order order) {
        orderPORepository.save(orderFactory.createOrderPO(order));
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderPORepository.findByUserId(userId).stream().map(orderFactory::createOrder).collect(Collectors.toList());
    }

    @Override
    public Order findById(Integer id) {
        return orderFactory.createOrder(orderPORepository.findById(id).orElse(null));
    }
}
