package com.example.demo.ejercicio30.validator;

import com.example.demo.ejercicio29.model.Person;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "person.age.required");
        
        Person person = (Person) target;

        if (person.getAge() != null && person.getAge() < 18) {
            errors.rejectValue("age", "person.age.gt18.required");
        }

        if (person.getName() == null || person.getName().length() < 1) {
            errors.rejectValue("name", "", "The name is required....");
        }
    }
    
}
