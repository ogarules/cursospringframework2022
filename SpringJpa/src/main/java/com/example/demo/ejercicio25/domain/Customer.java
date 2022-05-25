package com.example.demo.ejercicio25.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	private Long id;

	private String name;

	private String lastName;

	private User user;

}
