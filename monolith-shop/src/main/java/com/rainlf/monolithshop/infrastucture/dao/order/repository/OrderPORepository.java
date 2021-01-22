package com.rainlf.monolithshop.infrastucture.dao.order.repository;

import com.rainlf.monolithshop.infrastucture.dao.order.entity.OrderPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 19:07
 */
@Repository
public interface OrderPORepository extends JpaRepository<OrderPO, Integer> {
    List<OrderPO> findByUserId(Integer userId);
}
