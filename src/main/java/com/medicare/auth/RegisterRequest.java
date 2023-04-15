package com.medicare.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins ={"*"})
public class RegisterRequest {
    private String name;
    private String email;
    private  String password;
}
