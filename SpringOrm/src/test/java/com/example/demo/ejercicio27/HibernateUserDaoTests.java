package com.example.demo.ejercicio27;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.ejercicio27.dao.IAccountDAO;
import com.example.demo.ejercicio27.dao.ICustomerDAO;
import com.example.demo.ejercicio27.dao.IUserDAO;
import com.example.demo.ejercicio27.domain.Account;
import com.example.demo.ejercicio27.domain.Customer;
import com.example.demo.ejercicio27.domain.User;
import com.example.demo.ejercicio27.model.CustomDate;

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
public class HibernateUserDaoTests {
    
    @Autowired
    private IUserDAO userDao;

    @Autowired
    private ICustomerDAO customerDao;

    @Autowired
    private IAccountDAO accountDAO;

    @Test
    @Transactional
    public void insertTest() {
        log.info("Testing user dao insert ... ");
        
        User user = User.builder().username("oga").password("password").build();
        Customer customer = Customer.builder().lastName("oga").name("oga").user(user).build();
        user.setCustomer(customer);

        userDao.insert(user);

        User userDB = userDao.findById(user.getId());

        Assert.assertEquals(user.toString(), userDB.toString());

        log.info("{}", userDB);

        userDao.delete(userDB.getId());

        User userDB2 = userDao.findById(user.getId());

        Assert.assertNull(userDB2);

        List<User> all = userDao.findAll();
        
        Assert.assertTrue(all.size() > 0);

        ///////////////////////////////////////////////////////////////////////////////////////////////////

        Customer cust = customerDao.findById(1L);

        log.info("{}", cust);

        int accounts = cust.getAccounts().size();

        log.info("User Accounts {}", accounts);

        cust.getAccounts().add(Account.builder().accountNumber("111").balance(new BigDecimal(200))
                .createdDate(new CustomDate()).customer(cust).build());
        
        customerDao.update(cust);

        Customer custDb = customerDao.findById(1L);

        int accountsDB = custDb.getAccounts().size();

        Assert.assertEquals(accounts, accountsDB - 1);

        ///////////////////////////////////////////////////////////////////////////////////////////

        Account acc = accountDAO.findById(1L);
        List<Account> accs = accountDAO.findAll();
        
        List<Account> accountsCust = accountDAO.findByCustomerId(1L);

        Assert.assertEquals(accountsCust.size(), accountsDB);

        Account toRemove = custDb.getAccounts().get(2);
        toRemove.setCustomer(null);
        custDb.getAccounts().remove(toRemove);

        customerDao.update(custDb);

        List<Account> accountsCustDB = accountDAO.findByCustomerId(1L);

        Assert.assertEquals(accountsCustDB.size(), accounts);

        Account accCust = Account.builder().accountNumber("222").balance(new BigDecimal(200))
                .createdDate(new CustomDate()).customer(custDb).build();
                
        accountDAO.insert(accCust);

        List<Account> accountsCustDBNext = accountDAO.findByCustomerId(1L);

        Assert.assertEquals(accountsCustDBNext.size(), accounts + 1);
    }
}
