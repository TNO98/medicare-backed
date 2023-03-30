package com.medicare.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "User's name should not be blank")
    private String name;
    @Column(unique = true)
    private String email;
    @NotBlank(message = "User's password should not be blank")
    private String password;
    private Role role=Role.USER;

}
