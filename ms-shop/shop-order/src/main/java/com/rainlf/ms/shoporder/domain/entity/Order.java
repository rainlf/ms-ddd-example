package com.rainlf.ms.shoporder.domain.entity;

import com.rainlf.ms.shoporder.domain.entity.valueobject.Detail;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 18:08
 */
@Data
public class Order {
    private Integer id;
    private Integer userId;
    private List<Detail> detailList;
    private Status status;
    private Date createTime;

    public Order() {
    }

    public Order(Integer userId, List<Detail> detailList) {
        this.userId = userId;
        this.detailList = detailList;
        this.status = Status.CREATED;
        this.createTime = new Date();
    }
}
