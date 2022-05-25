package com.example.demo.ejercicio25.domain;

import java.math.BigDecimal;

import com.example.demo.ejercicio25.model.CustomDate;

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
public class Account {

	private Long id;

	private Customer customer;

	private String accountNumber;

	private CustomDate createdDate;

	private BigDecimal balance;

}
