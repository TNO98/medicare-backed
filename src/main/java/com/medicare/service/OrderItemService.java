package com.medicare.service;

import com.medicare.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem saveOrderItem(OrderItem orderItem);
    List<OrderItem> getAllOrderItem();
}
