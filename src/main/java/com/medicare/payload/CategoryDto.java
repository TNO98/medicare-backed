package com.medicare.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medicare.entity.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
   // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private String name;
    private String description;
    List<Medicine> medicine= new ArrayList<>();
}
