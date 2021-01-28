package com.rainlf.ms.shopgoods.infrastucture.feign;

import com.rainlf.ms.shopgoods.adapter.web.dto.WebResponse;

/**
 * @author : rain
 * @date : 2021/1/28 20:27
 */
public class UserFeignServiceFallback implements UserFeignService {
    @Override
    public WebResponse findById(Integer id) {
        return WebResponse.error("call UserFeignService failed");
    }
}
