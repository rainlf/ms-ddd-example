package com.rainlf.ms.shoporder.domain.repository;


import com.rainlf.ms.shoporder.domain.entity.Order;

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
