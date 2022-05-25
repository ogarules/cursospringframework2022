package com.example.demo.ejercicio26.springtx.service;

import com.example.demo.ejercicio26.springtx.BusinessObject;

public interface ITransactionalService {

	BusinessObject getBusinessObject(Long id);

	void insertBusinessObject(BusinessObject businessObject);

	void updateBusinessObject(BusinessObject businessObject);

	void deleteBusinessObject(Long id);
}
