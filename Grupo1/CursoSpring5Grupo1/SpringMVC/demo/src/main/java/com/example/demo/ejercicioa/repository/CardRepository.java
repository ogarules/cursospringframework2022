package com.example.demo.ejercicioa.repository;

import com.example.demo.ejercicioa.domain.Card;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    
}
