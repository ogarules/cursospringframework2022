package com.example.demo.ejercicioa.controller;

import com.example.demo.ejercicioa.domain.Card;
import com.example.demo.ejercicioa.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/card")
public class CardController {
    
    @Autowired
    CardService service;

    @GetMapping(value = "/{id}")
    public Card getCard(@PathVariable Long id) {
        return service.GetCardInf(id);
    }

    @GetMapping()
    public Iterable<Card> getAllCards() {
        return service.getAllCards();
    }    

    @PostMapping
    public Card addCard(@RequestBody Card entity) {
        return service.AddCard(entity);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Long id, @RequestBody Card entity) {
        
        Card cardDb = service.GetCardInf(id);

        cardDb.setCardExpiration(entity.getCardExpiration());
        cardDb.setCardName(entity.getCardName());
        cardDb.setCardNumber(entity.getCardNumber());

        service.UpdteCard(cardDb);

        return cardDb;
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        service.DeleteCard(id);        
    }
}
