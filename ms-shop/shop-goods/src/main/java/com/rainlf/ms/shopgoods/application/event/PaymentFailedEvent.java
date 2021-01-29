package com.rainlf.ms.shopgoods.application.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/29 11:25
 */
@Data
public class PaymentFailedEvent {
    List<OrderDetail> orderDetailList;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetail {
        private Integer id;
        private Integer number;
    }
}
