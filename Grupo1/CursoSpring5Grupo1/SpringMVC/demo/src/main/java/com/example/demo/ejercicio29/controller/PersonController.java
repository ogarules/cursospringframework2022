package com.example.demo.ejercicio29.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.example.demo.ejercicio29.model.Person;
import com.example.demo.ejercicio30.validator.PersonValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/person")
@SessionAttributes({"personCreated", "servertime"})
public class PersonController {
    
    private List<Person> persons = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    PersonValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String showPersonPage(@ModelAttribute("personForm") Person personForm, Model model) {
        log.info("Showing Person list and create.....");

        model.addAttribute("persons", persons);

        personForm.setName("Capture su bombre");
        personForm.setAge(100);

        model.addAttribute("personForm", personForm);

        return "person/list_and_create_person";

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(Model model, @ModelAttribute Person personForm, BindingResult result) {
        log.info("Creating person {} ....", personForm);

        validator.validate(personForm, result);

        if (result.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.personForm", result);
            model.addAttribute("personForm", personForm);
            model.addAttribute("servertime", new Date());

            return "/person/list_and_create_person";
        }
        
        persons.add(personForm);

        model.addAttribute("personCreated", personForm);
        model.addAttribute("servertime", new Date());

        return "forward:/person/showdata";
    }

    @RequestMapping(value = "/showdata", method = { RequestMethod.GET, RequestMethod.POST })
    public String showPerson(Model model, @ModelAttribute("personCreated") Person personCreated,
                             @ModelAttribute("servertime") Date serverTime ) {
        log.info("Showing info of person created {} ....", personCreated);

        model.addAttribute("personCreated", personCreated);
        model.addAttribute("servertime", serverTime);

        return "/person/showdata";
    }
}
