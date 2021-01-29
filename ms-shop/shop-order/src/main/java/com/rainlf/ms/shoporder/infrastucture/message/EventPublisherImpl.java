package com.rainlf.ms.shoporder.infrastucture.message;

import com.rainlf.ms.shoporder.application.event.publisher.EventPublisher;
import com.rainlf.ms.shoporder.application.event.OrderCreatedEvent;
import com.rainlf.ms.shoporder.application.event.PaymentFailedEvent;
import com.rainlf.ms.shoporder.application.event.PaymentSuccessEvent;
import com.rainlf.ms.shoporder.infrastucture.message.MessageTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author : rain
 * @date : 2021/1/29 11:38
 */
@Slf4j
@Service
public class EventPublisherImpl implements EventPublisher {
    @Autowired
    private MessageTopic topic;

    @Override
    public void sendOrderCreatedEvent(OrderCreatedEvent event) {
        log.info("send event: {}", event);
        topic.orderCreatedOut().send(MessageBuilder.withPayload(event).build());
    }

    @Override
    public void sendPaymentFailedEvent(PaymentFailedEvent event) {
        log.info("send event: {}", event);
        topic.paymentFailedOut().send(MessageBuilder.withPayload(event).build());
    }

    @Override
    public void sendPaymentSuccessEvent(PaymentSuccessEvent event) {
        log.info("send event: {}", event);
        topic.paymentSuccessOut().send(MessageBuilder.withPayload(event).build());
    }
}
