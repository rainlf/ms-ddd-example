package com.rainlf.ms.shopgoods.application.event.subscriber;

import com.rainlf.ms.shopgoods.application.event.OrderCreatedEvent;
import com.rainlf.ms.shopgoods.application.event.PaymentFailedEvent;
import com.rainlf.ms.shopgoods.application.event.PaymentSuccessEvent;
import com.rainlf.ms.shopgoods.application.service.GoodsAppService;
import com.rainlf.ms.shopgoods.domain.service.GoodsService;
import com.rainlf.ms.shopgoods.infrastucture.message.MessageTopic;
import com.rainlf.ms.shopgoods.infrastucture.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/29 11:57
 */
@Slf4j
@Component
public class EventListener {
    @Autowired
    private GoodsService goodsService;

    @StreamListener(value = MessageTopic.orderCreatedIn)
    public void receiveOrderCreatedEvent(String payload) {
        log.info("receive OrderCreatedEvent: {}", payload);
        OrderCreatedEvent event = JsonUtils.parseJson(payload, OrderCreatedEvent.class);
        event.getOrderDetailList().forEach(orderDetail -> goodsService.subtractInventory(orderDetail.getId(), orderDetail.getNumber()));
    }

    @StreamListener(value = MessageTopic.paymentSuccessIn)
    public void receivePaymentSuccessEvent(String payload) {
        log.info("receive PaymentSuccessEvent: {}", payload);
        PaymentSuccessEvent event = JsonUtils.parseJson(payload, PaymentSuccessEvent.class);
        event.getGoodsIdList().forEach(goodsId -> goodsService.addSellCount(goodsId));
    }

    @StreamListener(value = MessageTopic.paymentFailedIn)
    public void receivePaymentFailedEvent(String payload) {
        log.info("receive PaymentFailedEvent: {}", payload);
        PaymentFailedEvent event = JsonUtils.parseJson(payload, PaymentFailedEvent.class);
        event.getOrderDetailList().forEach(orderDetail -> goodsService.addInventory(orderDetail.getId(), orderDetail.getNumber()));
    }
}
