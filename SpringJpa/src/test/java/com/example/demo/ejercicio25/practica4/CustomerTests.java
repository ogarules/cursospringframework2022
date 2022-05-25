package com.example.demo.ejercicio25.practica4;

import java.util.List;

import com.example.demo.ejercicio25.dao.ICustomerDAO;
import com.example.demo.ejercicio25.dao.IUserDAO;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "classpath:spring/ejercicio25/spring-jdbc-config.xml")
//@ActiveProfiles("h2-in-memory")
@ActiveProfiles("mysql")
public class CustomerTests {
    @Autowired
	private IUserDAO userDAO;

	@Autowired
	private ICustomerDAO customerDAO;

	@Before
	public void setUp() {
		Assert.assertNotNull(userDAO);
		Assert.assertNotNull(customerDAO);
	}

	@Test
	public void createCustomerTest() {
		log.info("createCustomerTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		customerDAO.insert(newCustomer);

		log.info("newCustomer : {} {}", newCustomer,
				System.identityHashCode(newCustomer));

		log.info("newCustomer (detached) : {} {}", newCustomer,
				System.identityHashCode(newCustomer));

		Customer customer = customerDAO.findById(newCustomer.getId());

		Assert.assertEquals(customer, newCustomer);

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));

		User user = userDAO.findById(customer.getUser().getId());

		Assert.assertEquals(user, customer.getUser());

		log.info("user : {} {}", user, System.identityHashCode(user));

	}

	@Test
	public void updateCustomerTest() {
		log.info("updateCustomerTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		customerDAO.insert(newCustomer);

		log.info("newCustomer : {} {}", newCustomer,
				System.identityHashCode(newCustomer));

		log.info("newCustomer (detached) : {} {}", newCustomer,
				System.identityHashCode(newCustomer));

		Customer customer = customerDAO.findById(newCustomer.getId());

		Assert.assertEquals(customer, newCustomer);

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));

		customer.setName("Laura Valeria");
		customer.setLastName("Manrique");

		customer.getUser().setUsername("lauravaleria123");
		customer.getUser().setPassword("123456789");

		customerDAO.update(customer);

		log.info("customer (modified) : {} {}", customer,
				System.identityHashCode(customer));

		Customer modifiedCustomer = customerDAO.findById(customer.getId());

		Assert.assertEquals(modifiedCustomer, customer);

		log.info("modifiedCustomer : {} {}", modifiedCustomer,
				System.identityHashCode(modifiedCustomer));

		User user = userDAO.findById(modifiedCustomer.getUser().getId());

		Assert.assertEquals(user, modifiedCustomer.getUser());

		log.info("user : {} {}", user, System.identityHashCode(user));
	}

	@Test
	public void deleteCustomerTest() {
		log.info("deleteCustomerTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		customerDAO.insert(newCustomer);

		log.info("newCustomer : {} {}", newCustomer,
				System.identityHashCode(newCustomer));

		log.info("newCustomer (detached) : {} {}", newCustomer,
				System.identityHashCode(newCustomer));

		Customer customer = customerDAO.findById(newCustomer.getId());

		Assert.assertEquals(customer, newCustomer);

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));

		customerDAO.delete(customer);

		log.info("customer (deleted) : {} {}", customer,
				System.identityHashCode(customer));

		Customer deletedCustomer = customerDAO.findById(customer.getId());

		Assert.assertNull(deletedCustomer);

		log.info("deletedCustomer : {} {}", deletedCustomer,
				System.identityHashCode(deletedCustomer));

		User user = userDAO.findById(customer.getUser().getId());

		Assert.assertNull(user);

		log.info("user : {} {}", user, System.identityHashCode(user));
	}

	@Test
	public void findAllCustomerTest() {
		log.info("findAllCustomerTest -------------------");

		List<Customer> customers = customerDAO.findAll();
		log.info("customers : {}", customers);
	}
}
