package com.rainlf.ms.shoporder.infrastucture.dao.repository;

import com.rainlf.ms.shoporder.infrastucture.dao.model.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 19:07
 */
@Repository
public interface OrderDORepository extends JpaRepository<OrderDO, Integer> {
    List<OrderDO> findByUserId(Integer userId);
}
