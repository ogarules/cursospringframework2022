package com.example.demo.ejercicio26.springtx;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusinessObject {
	private Long id;
	private String data;
}

