package com.example.demo.ejercicio28.services;

import com.example.demo.ejercicio28.models.BeanComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
public class AddService implements IAddService {

	public Double add(Double... numbers) {

		Double z = 0D;

		if (numbers != null)
			for (Double n : numbers)
				z += n;

		return z;

	}
}
