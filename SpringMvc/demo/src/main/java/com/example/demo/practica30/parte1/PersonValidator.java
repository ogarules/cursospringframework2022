package com.example.demo.practica30.parte1;

import com.example.demo.ejercicio29.models.Person;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// Implementar
		return clazz.isAssignableFrom(Person.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Implementar Validacion
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "person.age.required", 
				"Age is required.");
		
		Person person = (Person)target;
		
		if (person.getAge() != null && person.getAge() < 18) {
			errors.rejectValue("age", "person.age.gt18.required", new Object[] { 18 },
					"Age must be greather or equal than N.");
		}

		if (person.getName() == null || person.getName().trim().isEmpty()) {
			errors.rejectValue("name", "", "Name is required.");
		}
	}

}
