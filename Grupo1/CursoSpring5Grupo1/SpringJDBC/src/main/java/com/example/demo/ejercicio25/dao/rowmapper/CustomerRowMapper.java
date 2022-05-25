package com.example.demo.ejercicio25.dao.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("USER_ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setUsername(rs.getString("USERNAME"));

        Customer customer = new Customer();
        customer.setId(rs.getLong("CUSTOMER_ID"));
        customer.setLastName(rs.getString("LAST_NAME"));
        customer.setName(rs.getString("NAME"));

        customer.setUser(user);
        user.setCustomer(customer);

        return customer;
    }
    
}
