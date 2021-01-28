package com.rainlf.ms.shopgoods.infrastucture.inject.facade;

import com.rainlf.ms.shopgoods.adapter.web.dto.WebResponse;
import com.rainlf.ms.shopgoods.application.dto.User;
import com.rainlf.ms.shopgoods.application.facade.UserService;
import com.rainlf.ms.shopgoods.infrastucture.feign.UserFeignService;
import com.rainlf.ms.shopgoods.infrastucture.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : rain
 * @date : 2021/1/28 20:24
 */
@Slf4j
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserFeignService userFeignService;

    @Override
    public User findById(Integer id) {
        WebResponse response = userFeignService.findById(id);
        log.info("receive response from feign: {}", response);
        if (response.getSuccess()) {
            return JsonUtils.parseJson(JsonUtils.toJson(response.getData()), User.class);
        } else {
            return null;
        }
    }
}
