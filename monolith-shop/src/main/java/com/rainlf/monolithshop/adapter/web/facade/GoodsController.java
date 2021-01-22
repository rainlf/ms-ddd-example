package com.rainlf.monolithshop.adapter.web.facade;

import com.rainlf.monolithshop.adapter.web.dto.WebResponse;
import com.rainlf.monolithshop.application.service.GoodsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : rain
 * @date : 2021/1/27 19:47
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsAppService goodsAppService;

    @GetMapping("")
    public WebResponse findGoods() {
        return WebResponse.ok(goodsAppService.findGoods());
    }
}
