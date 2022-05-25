package com.example.demo.ejercicio25.practica5;

import java.util.List;

import com.example.demo.ejercicio25.dao.IAccountDAO;
import com.example.demo.ejercicio25.dao.ICustomerDAO;
import com.example.demo.ejercicio25.dao.IUserDAO;
import com.example.demo.ejercicio25.domain.Account;
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
@ActiveProfiles("h2-in-memory")
//@ActiveProfiles("mysql")
public class AccountTests {
    @Autowired
	private IUserDAO userDAO;

	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private IAccountDAO accountDAO;

	@Before
	public void setUp() {
		Assert.assertNotNull(userDAO);
		Assert.assertNotNull(customerDAO);
		Assert.assertNotNull(accountDAO);
	}

	@Test
	public void accountSpringJdbcDAOTest() {
		log.info("accountSpringJdbcDAOTest -------------------");

		User user = userDAO.findById(1L);

		Customer customer = customerDAO.findById(1L);

		List<Account> accounts = accountDAO.findByCustomerId(customer.getId());

		Account account_2 = accountDAO.findById(2L);

		accountDAO.insert(account_2);

		Assert.assertNotNull(user);
		Assert.assertNotNull(customer);
		Assert.assertNotNull(accounts);
		Assert.assertNotNull(account_2);

		Assert.assertEquals("xvanhalenx", user.getUsername());
		Assert.assertEquals("oga", customer.getName());
		//Assert.assertEquals(account_2, accounts.get(2));

		log.info("user: {}", user);
		log.info("user.customer: {}", user.getCustomer());
		log.info("customer: {}", customer);

		log.info("accounts: {}", accounts);
		log.info("account_2: {}", account_2);
		
		accountDAO.insert(account_2);
	}
}
