package com.rainlf.monolithshop.application.service;

import com.rainlf.monolithshop.domain.order.model.Order;
import com.rainlf.monolithshop.domain.order.model.valueobject.Detail;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 19:51
 */
public interface OrderAppService {
    void createOrder(Integer userId, List<Detail> detailList);

    List<Order> findByUserId(Integer userId);

    void payForOrder(Integer id);
}
