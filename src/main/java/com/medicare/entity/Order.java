package com.medicare.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "orderItems")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "pk.order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems=new ArrayList<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    @CreationTimestamp
    private Date orderDate;

    @Transient
    public double getTotalOrderPrice(){
        double sum =0D;
        for (OrderItem ot : getOrderItems()){
            sum+=ot.getTotalPrice();
        }
        return sum;
    }
    @Transient
    public int getNumberOfMedicines(){
        return orderItems.size();
    }

}
