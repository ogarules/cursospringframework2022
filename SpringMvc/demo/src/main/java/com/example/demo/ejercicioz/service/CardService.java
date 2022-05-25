package com.example.demo.ejercicioz.service;

import java.util.List;

import com.example.demo.ejercicioz.model.Card;
import com.example.demo.ejercicioz.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired 
    CardRepository repository;

    public Card GetCardInf(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Card AddCard(Card card) {
        return repository.save(card);
    }

    public Iterable<Card> getAllCards() {
        return repository.findAll();
    }
}
