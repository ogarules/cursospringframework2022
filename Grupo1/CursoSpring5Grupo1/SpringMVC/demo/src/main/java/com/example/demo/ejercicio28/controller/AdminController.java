package com.example.demo.ejercicio28.controller;

import com.example.demo.ejercicio28.component.BeanComponent;
import com.example.demo.ejercicio28.service.IAddService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    BeanComponent component;

    @Autowired
    IAddService addService;


    @RequestMapping(value = { "", "/{name}" }, method = RequestMethod.GET)
    public String showAdminPage(Model model, @PathVariable(required = false) String name
            , @RequestParam(required = false, defaultValue = "1") Double n1
            , @RequestParam(required = false, defaultValue = "1") Double n2) {

        model.addAttribute("message", component.sayHello(name) + " => " + addService.add(n1, n2));

        return "admin";
    }
}
