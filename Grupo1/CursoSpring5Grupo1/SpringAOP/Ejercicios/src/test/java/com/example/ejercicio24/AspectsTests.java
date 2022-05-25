package com.example.ejercicio24;

import java.math.BigDecimal;

import com.example.ejercicio24.model.Account;
import com.example.ejercicio24.web.IAccountWebView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AspectsTests {
    @Autowired
    IAccountWebView view;

    @Test
    public void aspectsTest() {
        log.info("Testing....");

        view.showAccountsFromCustomerId(1L);
        Account acc = Account.builder().accountDescription("oga acount").accountNumber("2")
                .balance(new BigDecimal(100)).build();
        view.processFormUpdateBalance(acc, 200L);
        view.processFormUpdateDescription(acc);
    }
}
