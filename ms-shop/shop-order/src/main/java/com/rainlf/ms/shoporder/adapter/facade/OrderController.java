package com.rainlf.ms.shoporder.adapter.facade;

import com.rainlf.ms.shoporder.adapter.assembler.OrderAssembler;
import com.rainlf.ms.shoporder.adapter.dto.WebResponse;
import com.rainlf.ms.shoporder.adapter.dto.OrderDTO;
import com.rainlf.ms.shoporder.application.service.OrderAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * @author : rain
 * @date : 2021/1/27 20:22
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderAppService orderAppService;

    @PostMapping("")
    public WebResponse createOrder(@RequestBody OrderDTO orderDTO) {
        orderAppService.createOrder(orderDTO.getUserId(), OrderAssembler.toDetail(orderDTO.getDetailList()));
        return WebResponse.ok("create order success");
    }

    @GetMapping("")
    public WebResponse findOrderByUserId(@RequestParam("userId") Integer userId) {
        return WebResponse.ok(orderAppService.findByUserId(userId).stream().map(OrderAssembler::orderDTO).collect(Collectors.toList()));
    }

    @PostMapping("/pay")
    public WebResponse payForOrder(@RequestParam("orderId") Integer orderId) {
        orderAppService.payForOrder(orderId);
        return WebResponse.ok("pay success");
    }
}
