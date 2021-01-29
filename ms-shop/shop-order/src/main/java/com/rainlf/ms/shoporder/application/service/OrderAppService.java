package com.rainlf.ms.shoporder.application.service;


import com.rainlf.ms.shoporder.domain.model.Order;
import com.rainlf.ms.shoporder.domain.model.valueobject.Detail;

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
