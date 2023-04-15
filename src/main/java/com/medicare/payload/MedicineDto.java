package com.medicare.payload;

import com.medicare.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDto {
    private long id;
    private String name;
    private String brand;
    private double price;
    private String imageName;
    private Category category;

}
