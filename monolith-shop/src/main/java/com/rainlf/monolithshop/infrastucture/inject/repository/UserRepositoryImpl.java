package com.rainlf.monolithshop.infrastucture.inject.repository;

import com.rainlf.monolithshop.domain.user.entity.User;
import com.rainlf.monolithshop.domain.user.repository.UserRepository;
import com.rainlf.monolithshop.infrastucture.dao.user.factory.UserFactory;
import com.rainlf.monolithshop.infrastucture.dao.user.repository.UserPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : rain
 * @date : 2021/1/27 18:58
 */
@Service
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserPORepository userPORepository;

    @Autowired
    private UserFactory userFactory;

    @Override
    public void saveUser(User user) {
        userPORepository.save(userFactory.createUserPO(user));
    }

    @Override
    public User findByUsername(String username) {
        return userFactory.createUser(userPORepository.findByUsername(username));
    }
}
