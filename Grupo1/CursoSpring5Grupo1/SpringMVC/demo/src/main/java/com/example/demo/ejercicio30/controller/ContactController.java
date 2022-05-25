package com.example.demo.ejercicio30.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.example.demo.ejercicio30.model.Contact;
import com.example.demo.ejercicio30.validator.ContactValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/contact")
@SessionAttributes({"contactForm", "confirmationId" })
public class ContactController {
    @Autowired
    private ContactValidator validator;

    @InitBinder(value = "contactForm")
    private void configBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String getContactForm(Model model) {
        log.info("Getting contact form....");

        Contact contactForm = new Contact();

        contactForm.setHiddenMessage("contact-form-123");
        model.addAttribute("contactForm", contactForm);

        return "contact/contact_form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitContact(Model model, 
            @Valid @ModelAttribute("contactForm") Contact contactForm, BindingResult result) {
        log.info("Saving contact....");

        if (result.hasErrors()) {
            model.addAttribute("contactForm", contactForm);
            return "contact/contact_form";
        }

        String confirmationId = "1111.2222";
        model.addAttribute("confirmationId", confirmationId);
        model.addAttribute("contactForm", contactForm);

        return "redirect:/contact/success";
    }
    
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String showSuccess(@ModelAttribute("contactForm") Contact contactForm) {
        log.info("Showinf success....");

        return "contact/success";
    }

    @ModelAttribute("availableCourses")
    public List<String> availableCourses() {
        List<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("C#");
        courses.add("Python");
        courses.add("Angular");
        courses.add("React");

        return courses;
    }

    @ModelAttribute("vailableTutors")
    public List<String> vailableTutors() {
        List<String> tutors = new ArrayList<>();
        tutors.add("Mr. OGA");
        tutors.add("Mrs. Garcia");

        return tutors;
    }

    @ModelAttribute("genders")
    public List<String> genders() {
        List<String> genders = new ArrayList<>();
        genders.add("Female");
        genders.add("Male");

        return genders;
    }
}
