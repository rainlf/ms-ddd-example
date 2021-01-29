package com.rainlf.ms.shoporder.adapter.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author : rain
 * @date : 2021/1/27 20:22
 */
@Data
public class OrderDTO {
    private Integer id;
    private Integer userId;
    private List<DetailDTO> detailList;
    private String status;
    private Date createTime;

    @Data
    public static class DetailDTO {
        private Integer id;
        private String name;
        private Double price;
        private Integer number;
    }
}
