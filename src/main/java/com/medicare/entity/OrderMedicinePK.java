package com.medicare.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "order")
@EqualsAndHashCode
public class OrderMedicinePK implements Serializable {
    @Serial
    private static final long serialVersionUID = 476151177562655457L;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;
}
