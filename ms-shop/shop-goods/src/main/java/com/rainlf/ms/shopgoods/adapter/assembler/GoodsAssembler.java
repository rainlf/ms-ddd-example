package com.rainlf.ms.shopgoods.adapter.assembler;

import com.rainlf.ms.shopgoods.adapter.dto.GoodsDTO;
import com.rainlf.ms.shopgoods.domain.entity.Goods;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author : rain
 * @date : 2021/1/29 18:59
 */
@Component
public class GoodsAssembler {
    public GoodsDTO toGoodsDTO(Goods goods) {
        if (goods == null) {
            return null;
        }
        GoodsDTO goodsDTO = new GoodsDTO();
        BeanUtils.copyProperties(goods, goodsDTO);
        return goodsDTO;
    }
}
