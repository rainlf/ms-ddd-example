package com.rainlf.ms.shopgoods.application.facade;

import com.rainlf.ms.shopgoods.application.dto.User;

/**
 * @author : rain
 * @date : 2021/1/28 20:02
 */
public interface UserService {
    User findById(Integer id);
}
