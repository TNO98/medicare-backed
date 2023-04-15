package com.medicare.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medicare.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private UserDto userDto;
    private List<OrderItem> orderItems;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date orderDate;


    public double getTotalOrderPrice(){
        double sum =0D;
        for (OrderItem ot : getOrderItems()){
            sum+=ot.getTotalPrice();
        }
        return sum;
    }

    public int getNumberOfMedicines(){
        return orderItems.size();
    }


}
