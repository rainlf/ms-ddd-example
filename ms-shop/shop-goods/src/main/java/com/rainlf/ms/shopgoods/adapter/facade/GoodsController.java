package com.rainlf.ms.shopgoods.adapter.facade;

import com.rainlf.ms.shopgoods.adapter.assembler.GoodsAssembler;
import com.rainlf.ms.shopgoods.adapter.dto.WebResponse;
import com.rainlf.ms.shopgoods.application.service.GoodsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @author : rain
 * @date : 2021/1/27 19:47
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsAppService goodsAppService;

    @Autowired
    private GoodsAssembler goodsAssembler;

    @GetMapping("")
    public WebResponse findGoods(@RequestParam("userId") Integer userId) {
        return WebResponse.ok(goodsAppService.findGoods(userId).stream().map(x -> goodsAssembler.toGoodsDTO(x)).collect(Collectors.toList()));
    }
}
