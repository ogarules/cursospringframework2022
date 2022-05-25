package com.example.demo.ejercicio28;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndexPage(Model model) {

		model.addAttribute("message", "Hello World - Spring MVC");

		return "index";
	}

}