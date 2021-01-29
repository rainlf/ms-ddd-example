package com.rainlf.ms.shoporder.application.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/29 11:25
 */
@Data
public class OrderCreatedEvent {
    List<OrderDetail> orderDetailList;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetail {
        private Integer id;
        private Integer number;
    }
}
