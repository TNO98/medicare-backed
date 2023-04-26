package com.medicare.controller;
import com.medicare.entity.Medicine;
import com.medicare.entity.Order;
import com.medicare.entity.OrderItem;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.payload.OrderDto;
import com.medicare.payload.OrderItemDto;
import com.medicare.payload.UserDto;
import com.medicare.service.MedicineService;
import com.medicare.service.OrderItemService;
import com.medicare.service.OrderService;
import com.medicare.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@CrossOrigin(origins ={"*"})
public class OrderController {
    private final OrderService orderService;
    private final MedicineService medicineService;
    private final OrderItemService orderItemService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getAllMedicines(){
        return ResponseEntity.ok(this.orderService.getAllOrder());
    }

    @PostMapping("/")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderForm orderForm){
        List<OrderItemDto> orderItemDtos =orderForm.getOrderItemDtos();
        validateProductsExistence(orderItemDtos);
        OrderDto orderDto =new OrderDto();
        orderDto =this.orderService.saveOrder(orderDto);
        List<OrderItem> orderItems =new ArrayList<>();

        for (OrderItemDto oid: orderItemDtos){
            orderItems.add(orderItemService.saveOrderItem(new OrderItem(modelMapper.map(orderDto,Order.class),
                    modelMapper.map(medicineService.getMedicineById(oid.getMedicineDto().getId()), Medicine.class), oid.getQuantity())));
        }

        orderDto.setOrderItems(orderItems);
        orderDto.setUserDto(userService.findUserByEmail(orderForm.getCurrentUser().getEmail()));
        orderService.updateOrder(orderDto);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("api/order/{id}")
                .buildAndExpand(orderDto.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);
        return new ResponseEntity<>(orderDto, headers, HttpStatus.CREATED);
    }




    private void validateProductsExistence(List<OrderItemDto> orderItems) {
        List<OrderItemDto> list = orderItems
                .stream()
                .filter(oi -> Objects.isNull(medicineService.getMedicineById(oi
                                .getMedicineDto()
                        .getId())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            throw new ResourceNotFoundException("Medicine", "id", list.get(1).getMedicineDto().getId());
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderForm{
        private List<OrderItemDto> orderItemDtos;
        private UserDto currentUser;
    }

}
