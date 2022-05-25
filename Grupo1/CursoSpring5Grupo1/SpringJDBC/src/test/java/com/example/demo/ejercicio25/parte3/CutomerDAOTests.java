package com.example.demo.ejercicio25.parte3;

import com.example.demo.ejercicio25.dao.ICustomerDAO;
import com.example.demo.ejercicio25.dao.impl.h2.CustomerDAO;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ejercicio25/spring-jdbc.xml" })
@ActiveProfiles("h2-in-memory")
public class CutomerDAOTests {
    
    @Autowired
    ICustomerDAO customerDAO;

    @Test
    public void customerInsertTest() {
        log.info("Testing user dao insert");

        User user = User.builder().password("123123").username("oga123").build();
        Customer customer = Customer.builder().lastName("gaga").name("oga").user(user).build();

        user.setCustomer(customer);

        customerDAO.insert(customer);

        Customer customerInserted = customerDAO.findById(customer.getId());

        Assert.assertEquals(customer.toString(), customerInserted.toString());
    }
    
    @Test
    public void customerUpdateTest() {
        log.info("Testing user dao insert");

        User user = User.builder().password("123123").username("oga123").build();
        Customer customer = Customer.builder().lastName("gaga").name("oga").user(user).build();

        user.setCustomer(customer);

        customerDAO.insert(customer);

        Customer customerInserted = customerDAO.findById(customer.getId());
        customerInserted.setName("GAGAGAGAGA");

        customerDAO.update(customerInserted);

        Customer customerUpdated = customerDAO.findById(customerInserted.getId());

        Assert.assertEquals(customerUpdated.toString(), customerInserted.toString());
        Assert.assertNotEquals(customer.toString(), customerUpdated.toString());
    }

    @Test
    public void customerDeleteTest() {
        log.info("Testing user dao insert");

        User user = User.builder().password("123123").username("oga123").build();
        Customer customer = Customer.builder().lastName("gaga").name("oga").user(user).build();

        user.setCustomer(customer);

        customerDAO.insert(customer);

        Customer customerInserted = customerDAO.findById(customer.getId());

        Assert.assertEquals(customer.toString(), customerInserted.toString());

        customerDAO.delete(customerInserted);
        Customer customerDeleted = customerDAO.findById(customer.getId());

        Assert.assertNull(customerDeleted);
    }

    @Test
    public void findAllTest() {
        var result = customerDAO.findAll();

        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() > 0);
    }
}
