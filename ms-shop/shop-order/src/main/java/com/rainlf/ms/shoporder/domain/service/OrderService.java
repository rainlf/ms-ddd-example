package com.rainlf.ms.shoporder.domain.service;


import com.rainlf.ms.shoporder.domain.model.Order;
import com.rainlf.ms.shoporder.domain.model.valueobject.Detail;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 18:11
 */
public interface OrderService {
    void createOrder(Integer userId, List<Detail> detailList);

    List<Order> findByUserId(Integer userId);

    Boolean payForOrder(Order order);

    Order findById(Integer id);
}
