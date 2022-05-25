package com.example.demo.ejercicio26.springtx.service;

import com.example.demo.ejercicio26.springtx.BusinessObject;
import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
// Habilitar Trasnactional con aislamiento read commited y propagacion required
@Transactional(isolation=Isolation.READ_COMMITTED, propagation= Propagation.REQUIRED)
public class TransactionalService implements ITransactionalService {

	@Autowired
	private IColorWriter colorWriter;

	@Override
	// Habilitar Trasnactional read only
	@Transactional(readOnly=true)
	public BusinessObject getBusinessObject(Long id) {
		log.info("{}", colorWriter.getColoredMessage(Color.YELLOW,
				"inside getBusinessObject"));
		BusinessObject bo = BusinessObject.builder().id(id).data("some data")
				.build();
		return bo;
	}

	@Override
	public void insertBusinessObject(BusinessObject businessObject) {
		log.info("{}", colorWriter.getColoredMessage(Color.YELLOW,
				"inside insertBusinessObject"));
		throw new UnsupportedOperationException(
				"unsupported insertBusinessObject");
	}

	@Override
	public void updateBusinessObject(BusinessObject businessObject) {
		log.info("{}", colorWriter.getColoredMessage(Color.YELLOW,
				"inside updateBusinessObject"));
		throw new UnsupportedOperationException(
				"unsupported updateBusinessObject");
	}

	@Override
	public void deleteBusinessObject(Long id) {
		log.info("{}", colorWriter.getColoredMessage(Color.YELLOW,
				"inside deleteBusinessObject"));
		log.info("BusinessObject id: {} deleted", id);
	}

}
