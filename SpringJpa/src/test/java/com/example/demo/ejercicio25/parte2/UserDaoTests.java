package com.example.demo.ejercicio25.parte2;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.example.demo.ejercicio25.dao.IAccountDAO;
import com.example.demo.ejercicio25.dao.ICustomerDAO;
import com.example.demo.ejercicio25.dao.IUserDAO;
import com.example.demo.ejercicio25.domain.Account;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;
import com.example.demo.ejercicio25.model.CustomDate;

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
public class UserDaoTests {
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
	public void createUserTest() throws ParseException {
		log.info("createUserTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		userDAO.insert(newUser);

		log.info("newUser : {} {}", newUser, System.identityHashCode(newUser));

		log.info("newUser (detached) : {} {}", newUser,
				System.identityHashCode(newUser));

		User user = userDAO.findById(newUser.getId());

		Assert.assertEquals(user, newUser);

		log.info("user : {} {}", user, System.identityHashCode(user));

		Customer customer = customerDAO.findById(user.getCustomer().getId());

		Assert.assertEquals(user.getCustomer(), customer);

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));

		Account account = new Account();
		String today = "25/09/2021";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		account.setCustomer(customer);
		account.setAccountNumber("123");
		account.setBalance(new BigDecimal(100.0000));
		account.setCreatedDate(new CustomDate(formatter.parse(today).getTime()));

		accountDAO.insert(account);

		// Here we have a string date, and we want to covert it to long value
		Account accountBd = accountDAO.findById(account.getId());
		accountBd.setBalance(accountBd.getBalance().stripTrailingZeros());
		account.setBalance(account.getBalance().stripTrailingZeros());

		Assert.assertEquals(account, accountBd);

		log.info("{} - {}", account, accountBd);
	}
	
	@Test
	public void createCustomerTest() throws ParseException {
		log.info("createUserTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		customerDAO.insert(newCustomer);

		log.info("newUser : {} {}", newUser, System.identityHashCode(newUser));

		log.info("newUser (detached) : {} {}", newUser,
				System.identityHashCode(newUser));

		User user = userDAO.findById(newUser.getId());

		Assert.assertEquals(user, newUser);

		log.info("user : {} {}", user, System.identityHashCode(user));

		Customer customer = customerDAO.findById(user.getCustomer().getId());

		Assert.assertEquals(user.getCustomer(), customer);

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));

		Account account = new Account();
		String today = "25/09/2021";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		account.setCustomer(customer);
		account.setAccountNumber("123");
		account.setBalance(new BigDecimal(100.0000));
		account.setCreatedDate(new CustomDate(formatter.parse(today).getTime()));

		accountDAO.insert(account);

		// Here we have a string date, and we want to covert it to long value
        Account accountBd = accountDAO.findById(account.getId());
		accountBd.setBalance(accountBd.getBalance().stripTrailingZeros());
		account.setBalance(account.getBalance().stripTrailingZeros());
	
		Assert.assertEquals(account, accountBd);

		log.info("{} - {}", account, accountBd);
	}

	@Test
	public void updateUserTest() {
		log.info("updateUserTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		userDAO.insert(newUser);

		log.info("newUser : {} {}", newUser, System.identityHashCode(newUser));

		log.info("newUser (detached) : {} {}", newUser,
				System.identityHashCode(newUser));

		User user = userDAO.findById(newUser.getId());

		Assert.assertEquals(user, newUser);

		log.info("user : {} {}", user, System.identityHashCode(user));

		user.getCustomer().setName("Laura Valeria");
		user.getCustomer().setLastName("Manrique");

		user.setUsername("lauravaleria123");
		user.setPassword("123456789");

		userDAO.update(user);

		log.info("user (modified) : {} {}", user,
				System.identityHashCode(user));

		User modifiedUser = userDAO.findById(user.getId());

		Assert.assertEquals(modifiedUser, user);

		log.info("modifiedUser : {} {}", modifiedUser,
				System.identityHashCode(modifiedUser));

		Customer customer = customerDAO
				.findById(modifiedUser.getCustomer().getId());

		Assert.assertEquals(customer, modifiedUser.getCustomer());

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));

		customer.setLastName("gaga");
		customerDAO.update(customer);

		Customer customerbd = customerDAO
				.findById(modifiedUser.getCustomer().getId());

				Assert.assertEquals(customer, customerbd);	
	}

	@Test
	public void deleteUserTest() {
		log.info("deleteUserTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		userDAO.insert(newUser);

		log.info("newUser : {} {}", newUser, System.identityHashCode(newUser));

		log.info("newUser (detached) : {} {}", newUser,
				System.identityHashCode(newUser));

		User user = userDAO.findById(newUser.getId());

		Assert.assertEquals(user, newUser);

		log.info("user : {} {}", user, System.identityHashCode(user));

		userDAO.delete(user);

		log.info("user (deleted) : {} {}", user, System.identityHashCode(user));

		User deletedUser = userDAO.findById(user.getId());

		Assert.assertNull(deletedUser);

		log.info("deletedUser : {} {}", deletedUser,
				System.identityHashCode(deletedUser));

		Customer customer = customerDAO.findById(user.getCustomer().getId());

		Assert.assertNull(customer);

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));
	}

	@Test
	public void findAllUserTest() {
		log.info("findAllUserTest -------------------");

		List<User> users = userDAO.findAll();
		var accounts = accountDAO.findAll();
		var customers = customerDAO.findAll();
		log.info("users : {}", users);
	}
}
