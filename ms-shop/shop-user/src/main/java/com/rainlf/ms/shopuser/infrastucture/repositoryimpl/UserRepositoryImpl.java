package com.rainlf.ms.shopuser.infrastucture.repositoryimpl;

import com.rainlf.ms.shopuser.domain.entity.User;
import com.rainlf.ms.shopuser.domain.repository.UserRepository;
import com.rainlf.ms.shopuser.infrastucture.dao.convertor.UserConvertor;
import com.rainlf.ms.shopuser.infrastucture.dao.repository.UserDORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : rain
 * @date : 2021/1/27 18:58
 */
@Service
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserDORepository userDORepository;

    @Autowired
    private UserConvertor userConvertor;

    @Override
    public void saveUser(User user) {
        userDORepository.save(userConvertor.createUserPO(user));
    }

    @Override
    public User findByUsername(String username) {
        return userConvertor.createUser(userDORepository.findByUsername(username));
    }

    @Override
    public User findById(Integer id) {
        return userConvertor.createUser(userDORepository.findById(id).orElse(null));
    }
}
