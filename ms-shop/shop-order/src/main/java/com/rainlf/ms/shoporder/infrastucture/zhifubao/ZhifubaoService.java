package com.rainlf.ms.shoporder.infrastucture.zhifubao;

import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/28 11:54
 */
@Component
public class ZhifubaoService {
    public void pay() {
        if (Math.random() >= 0.5) {
            System.out.println("pay success");
        } else {
            System.out.println("pay failed");
            throw new RuntimeException("pay failed");
        }
    }
}
