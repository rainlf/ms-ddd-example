package com.rainlf.ms.shopuser.infrastucture.dao.repository;

import com.rainlf.ms.shopuser.infrastucture.dao.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : rain
 * @date : 2021/1/27 19:01
 */
@Repository
public interface UserDORepository extends JpaRepository<UserDO, Integer> {
    UserDO findByUsername(String username);
}
