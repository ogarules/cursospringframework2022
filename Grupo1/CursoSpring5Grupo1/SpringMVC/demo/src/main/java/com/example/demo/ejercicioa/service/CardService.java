package com.example.demo.ejercicioa.service;

import com.example.demo.ejercicioa.domain.Card;
import com.example.demo.ejercicioa.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CardService {
    @Autowired
    CardRepository repository;

    public Card GetCardInf(Long id) {
        var card = repository.findById(id).orElseThrow();
        log.info("{}", card);
        return card;
    }

    public Card AddCard(Card card) {
        return repository.save(card);
    }

    public Card UpdteCard(Card card) {
        return repository.save(card);
    }

    public void DeleteCard(Long id) {
        repository.deleteById(id);
    }

    public Iterable<Card> getAllCards() {
        return repository.findAll();
    }

}
