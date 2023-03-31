package com.medicare.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medicare.entity.Role;
import lombok.*;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private Role role;

}
