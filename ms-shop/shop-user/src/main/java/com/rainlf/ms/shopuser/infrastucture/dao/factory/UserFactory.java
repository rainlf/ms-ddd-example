package com.rainlf.ms.shopuser.infrastucture.dao.factory;

import com.rainlf.ms.shopuser.domain.entity.User;
import com.rainlf.ms.shopuser.infrastucture.dao.entity.UserPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/27 19:00
 */
@Component
public class UserFactory {
    public User createUser(UserPO userPO) {
        if (userPO == null) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(userPO, user);
        return user;
    }

    public UserPO createUserPO(User user) {
        if (user == null) {
            return null;
        }
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(user, userPO);
        return userPO;
    }
}
