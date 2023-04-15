package com.medicare.repository;

import com.medicare.entity.OrderItem;
import com.medicare.entity.OrderMedicinePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderMedicinePK> {
}
