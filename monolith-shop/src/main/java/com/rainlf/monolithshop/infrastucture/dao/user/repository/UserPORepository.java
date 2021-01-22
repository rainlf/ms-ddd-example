package com.rainlf.monolithshop.infrastucture.dao.user.repository;

import com.rainlf.monolithshop.infrastucture.dao.user.entity.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : rain
 * @date : 2021/1/27 19:01
 */
@Repository
public interface UserPORepository extends JpaRepository<UserPO, Integer> {
    UserPO findByUsername(String username);
}
