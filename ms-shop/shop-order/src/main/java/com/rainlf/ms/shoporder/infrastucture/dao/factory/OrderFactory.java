package com.rainlf.ms.shoporder.infrastucture.dao.factory;


import com.rainlf.ms.shoporder.domain.entity.Order;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Detail;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Status;
import com.rainlf.ms.shoporder.infrastucture.dao.entity.OrderPO;
import com.rainlf.ms.shoporder.infrastucture.util.JsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/27 19:14
 */
@Component
public class OrderFactory {
    public Order createOrder(OrderPO orderPO) {
        if (orderPO == null) {
            return null;
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderPO, order);
        order.setStatus(Status.fromCode(orderPO.getStatus()));
        order.setDetailList(JsonUtils.parseJsonList(orderPO.getDetailList(), Detail.class));
        return order;
    }

    public OrderPO createOrderPO(Order order) {
        if (order == null) {
            return null;
        }
        OrderPO orderPO = new OrderPO();
        BeanUtils.copyProperties(order, orderPO);
        orderPO.setStatus(order.getStatus().getCode());
        orderPO.setDetailList(JsonUtils.toJson(order.getDetailList()));
        return orderPO;
    }
}
