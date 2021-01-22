package com.rainlf.monolithshop.domain.order.repository;

import com.rainlf.monolithshop.domain.order.model.Order;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 18:16
 */
public interface OrderRepository {
    void saveOrder(Order order);

    List<Order> findByUserId(Integer userId);

    Order findById(Integer id);
}
