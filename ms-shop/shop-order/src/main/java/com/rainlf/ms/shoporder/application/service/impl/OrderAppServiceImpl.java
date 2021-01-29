package com.rainlf.ms.shoporder.application.service.impl;

import com.rainlf.ms.shoporder.application.event.publisher.EventPublisher;
import com.rainlf.ms.shoporder.application.event.OrderCreatedEvent;
import com.rainlf.ms.shoporder.application.event.PaymentFailedEvent;
import com.rainlf.ms.shoporder.application.event.PaymentSuccessEvent;
import com.rainlf.ms.shoporder.application.service.OrderAppService;
import com.rainlf.ms.shoporder.domain.entity.Order;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Detail;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Status;
import com.rainlf.ms.shoporder.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : rain
 * @date : 2021/1/27 19:52
 */
@Service
public class OrderAppServiceImpl implements OrderAppService {
    @Autowired
    private OrderService orderService;

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public void createOrder(Integer userId, List<Detail> detailList) {
        OrderCreatedEvent event = new OrderCreatedEvent();
        event.setOrderDetailList(detailList.stream()
                .map(x -> new OrderCreatedEvent.OrderDetail(x.getGoodsId(), x.getGoodsNumber()))
                .collect(Collectors.toList()));
        eventPublisher.sendOrderCreatedEvent(event);

        orderService.createOrder(userId, detailList);
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderService.findByUserId(userId);
    }

    @Override
    public void payForOrder(Integer id) {
        Order order = orderService.findById(id);
        if (order == null) {
            throw new RuntimeException(MessageFormat.format("order id not exists: {0}", id));
        }
        if (!Objects.equals(order.getStatus(), Status.CREATED)) {
            throw new RuntimeException(MessageFormat.format("order has been paid: {0}", id));
        }

        if (orderService.payForOrder(order)) {
            PaymentSuccessEvent event = new PaymentSuccessEvent();
            event.setGoodsIdList(order.getDetailList().stream().map(Detail::getGoodsId).collect(Collectors.toList()));
            eventPublisher.sendPaymentSuccessEvent(event);
        } else {
            PaymentFailedEvent event = new PaymentFailedEvent();
            event.setOrderDetailList(order.getDetailList().stream()
                    .map(x -> new PaymentFailedEvent.OrderDetail(x.getGoodsId(), x.getGoodsNumber()))
                    .collect(Collectors.toList()));
            eventPublisher.sendPaymentFailedEvent(event);
            throw new RuntimeException("pay failed");
        }
    }
}
