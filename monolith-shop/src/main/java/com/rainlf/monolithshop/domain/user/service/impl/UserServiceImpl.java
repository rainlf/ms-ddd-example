package com.rainlf.monolithshop.domain.user.service.impl;

import com.rainlf.monolithshop.domain.user.entity.User;
import com.rainlf.monolithshop.domain.user.repository.UserRepository;
import com.rainlf.monolithshop.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * @author : rain
 * @date : 2021/1/27 15:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new RuntimeException(MessageFormat.format("username already exists: {0}", username));
        }
        userRepository.saveUser(new User(username, password));
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException(MessageFormat.format("username not exists: {0}", username));
        }

        if (!Objects.equals(user.getPassword(), password)) {
            throw new RuntimeException("username or password wrong");
        }
        return user;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }
}
