package com.rainlf.ms.shopgoods.application.event;

import lombok.Data;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/29 11:25
 */
@Data
public class PaymentSuccessEvent {
    List<Integer> goodsIdList;
}
