package com.rainlf.ms.shopgoods.infrastucture.dao.repository;

import com.rainlf.ms.shopgoods.infrastucture.dao.entity.GoodsPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author : rain
 * @date : 2021/1/27 18:53
 */
@Repository
public interface GoodsPORepository extends JpaRepository<GoodsPO, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(nativeQuery = true, value = "update shop_goods set inventory = inventory + ?2 where id = ?1")
    void addInventory(Integer id, Integer inventory);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(nativeQuery = true, value = "update shop_goods set inventory = inventory - :inventory where id = :id")
    void subtractInventory(Integer id, Integer inventory);
}
