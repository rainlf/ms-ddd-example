package com.rainlf.monolithshop.infrastucture.dao.order.factory;

import com.rainlf.monolithshop.domain.order.model.Order;
import com.rainlf.monolithshop.domain.order.model.valueobject.Detail;
import com.rainlf.monolithshop.domain.order.model.valueobject.Status;
import com.rainlf.monolithshop.infrastucture.dao.order.entity.OrderPO;
import com.rainlf.monolithshop.infrastucture.util.JsonUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
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
