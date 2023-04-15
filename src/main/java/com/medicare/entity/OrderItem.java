package com.medicare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderItem {
    @EmbeddedId
    @JsonIgnore
    private OrderMedicinePK pk;
    private int quantity;

    public OrderItem(Order order, Medicine medicine, Integer quantity) {
        pk = new OrderMedicinePK();
        pk.setOrder(order);
        pk.setMedicine(medicine);
        this.quantity = quantity;
    }

    @Transient
    public double getTotalPrice(){
        return getMedicine().getPrice()*getQuantity();
    }
    @Transient
    public Medicine getMedicine(){return this.pk.getMedicine();}


}
