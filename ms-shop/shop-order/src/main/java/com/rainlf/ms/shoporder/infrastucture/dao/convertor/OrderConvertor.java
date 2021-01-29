package com.rainlf.ms.shoporder.infrastucture.dao.convertor;


import com.rainlf.ms.shoporder.domain.entity.Order;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Detail;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Status;
import com.rainlf.ms.shoporder.infrastucture.dao.model.OrderDO;
import com.rainlf.ms.shoporder.infrastucture.util.JsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/27 19:14
 */
@Component
public class OrderConvertor {
    public Order createOrder(OrderDO orderDO) {
        if (orderDO == null) {
            return null;
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderDO, order);
        order.setStatus(Status.fromCode(orderDO.getStatus()));
        order.setDetailList(JsonUtils.parseJsonList(orderDO.getDetailList(), Detail.class));
        return order;
    }

    public OrderDO createOrderPO(Order order) {
        if (order == null) {
            return null;
        }
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(order, orderDO);
        orderDO.setStatus(order.getStatus().getCode());
        orderDO.setDetailList(JsonUtils.toJson(order.getDetailList()));
        return orderDO;
    }
}
