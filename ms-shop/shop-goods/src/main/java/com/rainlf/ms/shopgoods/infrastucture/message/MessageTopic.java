package com.rainlf.ms.shopgoods.infrastucture.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @author : rain
 * @date : 2021/1/29 12:00
 */
public interface MessageTopic {
    String orderCreatedIn = "order-created-in";
    String paymentSuccessIn = "payment-success-in";
    String paymentFailedIn = "payment-failed-in";

    @Input(orderCreatedIn)
    MessageChannel orderCreatedIn();

    @Input(paymentSuccessIn)
    MessageChannel paymentSuccessIn();

    @Input(paymentFailedIn)
    MessageChannel paymentFailedIn();
}
