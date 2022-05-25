package com.example.demo.ejercicio27;

import java.math.BigDecimal;

import com.example.demo.ejercicio27.dao.ICustomerDAO;
import com.example.demo.ejercicio27.dao.IUserDAO;
import com.example.demo.ejercicio27.domain.Account;
import com.example.demo.ejercicio27.domain.Customer;
import com.example.demo.ejercicio27.domain.User;
import com.example.demo.ejercicio27.models.CustomDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio27/spring-orm.xml" })
@ActiveProfiles("h2-in-memory")
@Transactional
public class UserDAOTests {
    @Autowired
    IUserDAO userDAO;

    @Autowired
    ICustomerDAO customerDAO;

    @Test 
    public void inserUserTest() {
        log.info("inserting user ....");
        org.springframework.orm.hibernate5.LocalSessionFactoryBean s;
        
        User user = User.builder().username("oga").password("1234").build();
        Customer customer = Customer.builder().lastName("ogaga").name("oga").user(user).build();

        user.setCustomer(customer);

        userDAO.insert(user);

        User userDB = userDAO.findById(user.getId());

        Assert.assertEquals(user.toString(), userDB.toString());

        log.info(userDB.toString());

        Customer cust1 = customerDAO.findById(1L);

        cust1.getAccounts().add(Account.builder().accountNumber("123")
                .balance(new BigDecimal(100)).createdDate(new CustomDate()).customer(cust1).build());

        customerDAO.update(cust1);

        Customer cust2 = customerDAO.findById(1L);

        Assert.assertEquals(cust1.getAccounts().size(), cust2.getAccounts().size());

        Account acc1 = cust2.getAccounts().get(2);
        cust2.getAccounts().remove(acc1);
        acc1.setCustomer(null);

        customerDAO.update(cust2);

        Customer cust3 = customerDAO.findById(1L);

        Assert.assertEquals(cust2.getAccounts().size(), cust3.getAccounts().size());

    }
}
