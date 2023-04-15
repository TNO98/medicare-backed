package com.medicare.payload;

import com.medicare.entity.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private MedicineDto medicineDto;
    private Integer quantity;

}
