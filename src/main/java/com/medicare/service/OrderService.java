package com.medicare.service;

import com.medicare.payload.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrder();
    OrderDto getOrderById(long id);
    OrderDto saveOrder(OrderDto orderDto);
    void deleteOrder(long id);
    void updateOrder(OrderDto orderDto);
}
