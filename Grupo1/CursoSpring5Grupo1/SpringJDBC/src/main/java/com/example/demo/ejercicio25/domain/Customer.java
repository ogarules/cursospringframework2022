package com.example.demo.ejercicio25.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = { "user" })
@EqualsAndHashCode(exclude = { "user" })
public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private User user;
}
