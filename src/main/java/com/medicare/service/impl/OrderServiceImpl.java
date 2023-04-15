package com.medicare.service.impl;

import com.medicare.entity.Order;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.payload.OrderDto;
import com.medicare.repository.OrderRepository;
import com.medicare.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<OrderDto> getAllOrder() {
        return orderRepository.findAll()
                .stream()
                .map(o->modelMapper.map(o,OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(long id) {

        return modelMapper
                .map(orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","id",id)),OrderDto.class);
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        Order order=modelMapper.map(orderDto, Order.class);
        return modelMapper.map(orderRepository.save(order),OrderDto.class);
    }

    @Override
    public void deleteOrder(long id) {
        if (orderRepository.existsById(id)) orderRepository.deleteById(id);
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        this.orderRepository.save(modelMapper.map(orderDto,Order.class));
    }
}
