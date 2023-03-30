package com.medicare.payload;

import com.medicare.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private int unitsAvailable;
    private Category category;

}
