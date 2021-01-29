package com.rainlf.ms.shopuser.infrastucture.dao.convertor;

import com.rainlf.ms.shopuser.domain.entity.User;
import com.rainlf.ms.shopuser.infrastucture.dao.model.UserDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/27 19:00
 */
@Component
public class UserConvertor {
    public User createUser(UserDO userDO) {
        if (userDO == null) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(userDO, user);
        return user;
    }

    public UserDO createUserPO(User user) {
        if (user == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user, userDO);
        return userDO;
    }
}
