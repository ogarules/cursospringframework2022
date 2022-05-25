package com.example.demo.ejercicio28;

import com.example.demo.ejercicio28.models.BeanComponent;
import com.example.demo.ejercicio28.services.IAddService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
class AdminController {

	@Autowired
	BeanComponent beanComponent;

	@Autowired
	IAddService service;

	@RequestMapping(value = { "", "/{name}" }, method = RequestMethod.GET)
	public String showIndexPage(Model model, @PathVariable(required = false) String name,
			@RequestParam(required = false, defaultValue = "1") Double n1,
	@RequestParam(required = false, defaultValue = "1") Double n2 )  {
        
        model.addAttribute("message", beanComponent.sayHello(name) + " " + service.add(n1, n2));

		return "admin";
	}

}