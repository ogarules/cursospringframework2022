package com.example.demo.ejercicio30.validator;

import javax.swing.text.AbstractDocument.Content;

import com.example.demo.ejercicio30.model.Contact;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ContactValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Contact.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contact contact = (Contact) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Contact name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "", "The gender is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "The password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "", "The confirmed password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tutor", "", "The tutor is required");

        if (!contact.getEmail()
                .matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            errors.rejectValue("email", "", "The provided email is not valid");
        }

        if (!contact.getPassword().equals(contact.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "", "The condifrmed password and the password must be equal");
        }
        
        if (contact.getCourses() == null || contact.getCourses().isEmpty()) {
            errors.rejectValue("courses", "", "You must select at least one course");
        }


    }
    
}
