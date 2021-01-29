package com.rainlf.ms.shopuser.infrastucture.repositoryimpl;

import com.rainlf.ms.shopuser.domain.entity.User;
import com.rainlf.ms.shopuser.domain.repository.UserRepository;
import com.rainlf.ms.shopuser.infrastucture.dao.factory.UserFactory;
import com.rainlf.ms.shopuser.infrastucture.dao.repository.UserPORepository;
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

    @Override
    public User findById(Integer id) {
        return userFactory.createUser(userPORepository.findById(id).orElse(null));
    }
}
