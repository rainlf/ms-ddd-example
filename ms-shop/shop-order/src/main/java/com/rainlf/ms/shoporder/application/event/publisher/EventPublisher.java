package com.rainlf.ms.shoporder.application.event.publisher;

import com.rainlf.ms.shoporder.application.event.OrderCreatedEvent;
import com.rainlf.ms.shoporder.application.event.PaymentFailedEvent;
import com.rainlf.ms.shoporder.application.event.PaymentSuccessEvent;

/**
 * @author : rain
 * @date : 2021/1/29 11:24
 */
public interface EventPublisher {

    void sendOrderCreatedEvent(OrderCreatedEvent event);

    void sendPaymentFailedEvent(PaymentFailedEvent event);

    void sendPaymentSuccessEvent(PaymentSuccessEvent event);
}
