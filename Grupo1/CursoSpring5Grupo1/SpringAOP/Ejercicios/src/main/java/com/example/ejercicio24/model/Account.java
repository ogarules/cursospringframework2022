package com.example.ejercicio24.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
	private String accountNumber;
	private String accountDescription;
	private BigDecimal balance;
}