package com.rainlf.ms.shopgoods.infrastucture.feign;

import com.rainlf.ms.shopgoods.adapter.dto.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : rain
 * @date : 2021/1/28 20:17
 */
@FeignClient(value = "SHOP-USER", path = "/user", fallback = UserFeignServiceFallback.class)
public interface UserFeignService {

    @GetMapping("/{id}")
    WebResponse findById(@PathVariable("id") Integer id);
}
