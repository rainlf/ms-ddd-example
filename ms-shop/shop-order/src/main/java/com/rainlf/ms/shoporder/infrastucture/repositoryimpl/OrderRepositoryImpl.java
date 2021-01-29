package com.rainlf.ms.shoporder.infrastucture.repositoryimpl;

import com.rainlf.ms.shoporder.domain.entity.Order;
import com.rainlf.ms.shoporder.domain.repository.OrderRepository;
import com.rainlf.ms.shoporder.infrastucture.dao.convertor.OrderConvertor;
import com.rainlf.ms.shoporder.infrastucture.dao.repository.OrderDORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : rain
 * @date : 2021/1/27 19:06
 */
@Service
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private OrderDORepository orderDORepository;

    @Autowired
    private OrderConvertor orderConvertor;

    @Override
    public void saveOrder(Order order) {
        orderDORepository.save(orderConvertor.createOrderPO(order));
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderDORepository.findByUserId(userId).stream().map(orderConvertor::createOrder).collect(Collectors.toList());
    }

    @Override
    public Order findById(Integer id) {
        return orderConvertor.createOrder(orderDORepository.findById(id).orElse(null));
    }
}
