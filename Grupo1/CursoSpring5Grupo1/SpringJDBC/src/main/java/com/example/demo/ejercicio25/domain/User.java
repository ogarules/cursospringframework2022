package com.example.demo.ejercicio25.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = { "customer" })
@EqualsAndHashCode(exclude = { "customer" })
public class User {
    
    private Long id;
    private String username;
    private String password;
    private Customer customer;
}
