package com.rainlf.ms.shoporder.adapter.assembler;

import com.rainlf.ms.shoporder.adapter.dto.OrderDTO;
import com.rainlf.ms.shoporder.domain.entity.Order;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Detail;
import com.rainlf.ms.shoporder.domain.entity.valueobject.Status;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : rain
 * @date : 2021/1/27 20:34
 */
@Component
public class OrderAssembler {
    public Order toOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        order.setStatus(Status.fromValue(orderDTO.getStatus()));
        order.setDetailList(toDetail(orderDTO.getDetailList()));
        return order;
    }

    public OrderDTO orderDTO(Order order) {
        if (order == null) {
            return null;
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);
        orderDTO.setStatus(order.getStatus().getValue());
        orderDTO.setDetailList(toDetailDTO(order.getDetailList()));
        return orderDTO;
    }

    public List<Detail> toDetail(List<OrderDTO.DetailDTO> detailDTOList) {
        if (detailDTOList == null) {
            return null;
        }
        return detailDTOList.stream()
                .map(detailDTO -> new Detail(detailDTO.getId(), detailDTO.getName(), detailDTO.getPrice(), detailDTO.getNumber()))
                .collect(Collectors.toList());
    }

    private List<OrderDTO.DetailDTO> toDetailDTO(List<Detail> detailList) {
        if (detailList == null) {
            return null;
        }
        return detailList.stream()
                .map(detail -> {
                    OrderDTO.DetailDTO detailDTO = new OrderDTO.DetailDTO();
                    detailDTO.setId(detail.getGoodsId());
                    detailDTO.setName(detail.getGoodsName());
                    detailDTO.setPrice(detail.getGoodsPrice());
                    detailDTO.setNumber(detail.getGoodsNumber());
                    return detailDTO;
                })
                .collect(Collectors.toList());
    }
}
