package com.example.demo.ejercicio26.service;

import com.example.demo.ejercicio26.domain.BusinessObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class TransactionalService implements ITransactionalService {

    @Transactional(readOnly = true)
    @Override
    public BusinessObject getBusinessObject(Long id) {
        log.info("[Transactional Service] Getting business object");

        return BusinessObject.builder().id(id).data("oga").build();
    }

    @Override
    public void insertBusinessObject(BusinessObject businessObject) {
        log.info("[Transactional Service] Inserting business object");
        throw new UnsupportedOperationException("unsupported insert");        
    }

    @Override
    public void updateBusinessObject(BusinessObject businessObject) {
        log.info("[Transactional Service] Updating business object");
        throw new UnsupportedOperationException("unsupported insert");        
    }

    @Override
    public void deleteBusinessObject(Long id) {
        log.info("[Transactional Service] Deleting business object {}", id);
        
    }
    
}
