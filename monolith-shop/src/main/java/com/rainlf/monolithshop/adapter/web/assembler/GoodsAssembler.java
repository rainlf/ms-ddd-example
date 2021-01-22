package com.rainlf.monolithshop.adapter.web.assembler;

import com.rainlf.monolithshop.adapter.web.dto.GoodsDTO;
import com.rainlf.monolithshop.domain.goods.model.Goods;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @author : rain
 * @date : 2021/1/27 19:46
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GoodsAssembler {
    public GoodsDTO toGoodsDTO(Goods goods) {
        GoodsDTO goodsDTO = new GoodsDTO();
        BeanUtils.copyProperties(goodsDTO, goodsDTO);
        return goodsDTO;
    }
}
