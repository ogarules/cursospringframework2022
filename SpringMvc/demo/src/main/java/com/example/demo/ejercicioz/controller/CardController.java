package com.example.demo.ejercicioz.controller;

import com.example.demo.ejercicioz.aspect.MaskCard;
import com.example.demo.ejercicioz.model.Card;
import com.example.demo.ejercicioz.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    CardService service;

    @MaskCard
    @GetMapping(value = "/{id}")
    public Card getCard(@PathVariable Long id) {
        return service.GetCardInf(id);
    }

    @GetMapping()
    public Iterable<Card> getAllCards() {
        Card df = new Card();
        df.setCardNumber("a");
        String h = df.getCardNumber();
        return service.getAllCards();
    }    

    @PostMapping
    public Card addCard(@RequestBody Card entity) {
        return service.AddCard(entity);
    }
    
    
}
