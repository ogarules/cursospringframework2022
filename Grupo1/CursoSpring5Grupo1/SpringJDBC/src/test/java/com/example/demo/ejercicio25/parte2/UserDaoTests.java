package com.example.demo.ejercicio25.parte2;

import com.example.demo.ejercicio25.dao.IUserDAO;
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
@ActiveProfiles({"h2-in-memory"})
public class UserDaoTests {
    @Autowired
    IUserDAO userDao;

    @Test 
    public void userDaoInsertTest() {
        log.info("Testing user dao insert");

        User user = User.builder().password("123123").username("oga123").build();
        Customer customer = Customer.builder().lastName("gaga").name("oga").user(user).build();

        user.setCustomer(customer);

        userDao.insert(user);

        User userInserted = userDao.findById(user.getId());
        
        Assert.assertEquals(user.toString(), userInserted.toString());
    }
}
