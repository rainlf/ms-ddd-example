package com.rainlf.ms.shoporder.infrastucture.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author : rain
 * @date : 2021/1/29 11:21
 */
public interface MessageTopic {

    @Output("order-created-out")
    MessageChannel orderCreatedOut();

    @Output("payment-success-out")
    MessageChannel paymentSuccessOut();

    @Output("payment-failed-out")
    MessageChannel paymentFailedOut();
}
