package com.medicare.service.impl;

import com.medicare.entity.OrderItem;
import com.medicare.repository.OrderItemRepository;
import com.medicare.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrderItem() {
        return orderItemRepository.findAll();
    }
}
