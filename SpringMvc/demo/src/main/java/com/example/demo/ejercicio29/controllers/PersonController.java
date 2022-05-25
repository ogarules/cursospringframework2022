package com.example.demo.ejercicio29.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.example.demo.ejercicio29.models.Person;
import com.example.demo.practica30.parte1.PersonValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/person")
@SessionAttributes({"personCreated","servertime"})
public class PersonController {

    private List<Person> persons = Collections.synchronizedList(new ArrayList<Person>());
    
    // practica 30 parte 1
    @Autowired
    PersonValidator validator;

	// Implementar request mapping "/" y "" por metodo GET
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	//public String showPersonsPage(Model model) {
    public String showPersonsPage(@ModelAttribute("personForm") Person personForm, Model model) {

		log.info("showPersonsPage ---------------->");

		// Agregar la coleccion persons al modelo
		model.addAttribute("persons", persons);

		// Agregar comando "personForm"
       // Person personForm = new Person();
       personForm.setAge(100);
       personForm.setName("Fill");
		model.addAttribute("personForm", personForm);
		
		return "person/list_and_create_person";
	}

	// Implementar request mapping "/create" por metodo POST
	@RequestMapping(value="/create", method = RequestMethod.POST)
	// Recibir como argumento el Person que proviene del formulario
    public String createPerson(Model model, @ModelAttribute Person personForm
    // Practica30 parte1
    ,BindingResult result, SessionStatus status
    ) {

         //Validation code
            validator.validate(personForm, result);
            
            //Check validation errors
            if (result.hasErrors()) {

                model.addAttribute("org.springframework.validation.BindingResult.personForm", result);
                // Agregar "personCreated" al modelo siendo �ste objeto el obtenido
                // desde el formulario
                model.addAttribute("personForm", personForm);

                // Agregar "servertime" (new Date()) al modelo
                model.addAttribute("servertime", new Date());
                return "person/list_and_create_person";
            }
            
		log.info("createPerson ---------------->");

		log.info("processing form ...............");

		// Agregar el person que proviene del formulario al listado "persons"
		persons.add(personForm);

		// Agregar "personCreated" al modelo siendo �ste objeto el obtenido
		// desde el formulario
		model.addAttribute("personCreated", personForm);

		// Agregar "servertime" (new Date()) al modelo
		model.addAttribute("servertime", new Date());

		// return "person/show_person_data"; // forward
		return "redirect:/person/showdata"; // sendRedirect
	}

	// En sessiones es necesario obtener los objetos de la sesi�n mediante el
	// valor explicito sobre la anotaci�n @ModelAttribute.
	// Implementar request mapping "/showdata" por metodo GET
    @RequestMapping(value = "/showdata", method = { RequestMethod.GET, RequestMethod.POST })
	public String showPerson(Model model, @ModelAttribute("personCreated") Person personCreated,
			@ModelAttribute("servertime") Date servertime) {

		log.info("showPerson ---------------->");

		// Se vuelven a agregar los datos al modelo para que sean accesibles en
		// la vista
		model.addAttribute("personCreated", personCreated);
		model.addAttribute("servertime", servertime);

		return "person/show_person_data";
	}

}
