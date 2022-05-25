package com.example.demo.ejercicio25.dao.springjdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		User usr = new User();
		usr.setId(rs.getLong("USER_ID"));
		usr.setPassword(rs.getString("PASSWORD"));
		usr.setUsername(rs.getString("USERNAME"));
		
		Customer customer = new Customer();
		customer.setId(rs.getLong("CUSTOMER_ID"));
		customer.setName(rs.getString("NAME"));
		customer.setLastName(rs.getString("LAST_NAME"));
		
		customer.setUser(usr);
		usr.setCustomer(customer);
		
		return customer;
	}

}
