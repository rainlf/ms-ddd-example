package com.rainlf.monolithshop.infrastucture.inject.facade;

import com.rainlf.monolithshop.domain.order.facade.PaymentService;
import com.rainlf.monolithshop.infrastucture.zhifubao.ZhifubaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : rain
 * @date : 2021/1/28 11:59
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private ZhifubaoService zhifubaoService;

    @Override
    public Boolean pay() {
        boolean success = true;
        try {
            zhifubaoService.pay();
        } catch (Exception e) {
            log.error("zhifubao pay failed");
            success = false;
        }
        return success;
    }
}
