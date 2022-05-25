package com.example.demo.ejercicioz.repository;

import com.example.demo.ejercicioz.model.Card;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    
}
