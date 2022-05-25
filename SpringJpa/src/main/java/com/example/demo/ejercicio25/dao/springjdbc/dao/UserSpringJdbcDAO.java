package com.example.demo.ejercicio25.dao.springjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.ejercicio25.dao.IUserDAO;
import com.example.demo.ejercicio25.dao.springjdbc.GenericSpringJdbcDAO;
import com.example.demo.ejercicio25.dao.springjdbc.rowmapper.UserRowMapper;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.SneakyThrows;

@Repository
@Profile({ "h2-in-memory", "h2-local", "mysql" })
public class UserSpringJdbcDAO extends GenericSpringJdbcDAO<User, Long>
		implements IUserDAO {

	private static final String INSERT_CUSTOMER = "INSERT INTO SPRING_DATA_CUSTOMER_TBL(NAME,LAST_NAME) VALUES (?, ?)";
	private static final String INSERT_USER = "INSERT INTO SPRING_DATA_USER_TBL(FK_CUSTOMER_ID,USERNAME,PASSWORD) VALUES (?, ?, ?)";

	private static final String UPDATE_CUSTOMER = "UPDATE SPRING_DATA_CUSTOMER_TBL SET NAME = ?, LAST_NAME = ? WHERE CUSTOMER_ID = ?";
	private static final String UPDATE_USER = "UPDATE SPRING_DATA_USER_TBL SET USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?";

	private static final String SELECT_USER_CUSTOMER_WHERE_USER_ID = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL INNER JOIN SPRING_DATA_USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID WHERE USER_ID = ?";
	private static final String SELECT_ALL_USER_CUSTOMER = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL INNER JOIN SPRING_DATA_USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID";

	private static final String SELECT_ALL_CUSTOMER = "SELECT CUSTOMER_ID as ID, NAME, LAST_NAME as LASTNAME FROM SPRING_DATA_CUSTOMER_TBL";

	private static final String SELECT_USER_WHERE_CUSTOMER_ID = "SELECT USER_ID as ID, USERNAME, PASSWORD FROM SPRING_DATA_USER_TBL WHERE FK_CUSTOMER_ID = ?";

	private static final String DELETE_ACCOUNT_WHERE_CUSTOMER_ID = "DELETE FROM SPRING_DATA_ACCOUNT_TBL WHERE FK_CUSTOMER_ID = ?";
	private static final String DELETE_USER_WHERE_USER_ID = "DELETE FROM SPRING_DATA_USER_TBL WHERE USER_ID = ?";
	private static final String DELETE_CUSTOMER_WHERE_CUSTOMER_ID = "DELETE FROM SPRING_DATA_CUSTOMER_TBL WHERE CUSTOMER_ID = ?";

	@Override
	public void insert(User entity) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		// Implementado mediante PreparedStatementCreator y keyHolder
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				// Implementar
				PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER,
						new String[]{"CUSTOMER_ID"});
				
				ps.setString(1, entity.getCustomer().getName());
				ps.setString(2, entity.getCustomer().getLastName());
				return ps;
			}
		}, keyHolder);
		
		entity.getCustomer().setId( keyHolder.getKey().longValue() );

		// Implementar INSERT USER recuperando fk_customer_id
		keyHolder = new GeneratedKeyHolder();

		// Implementado mediante PreparedStatementCreator y keyHolder
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				// Implementar
				PreparedStatement ps = connection.prepareStatement(INSERT_USER,
						new String[] { "USER_ID"});
				
				ps.setLong(1, entity.getCustomer().getId());
				ps.setString(2,  entity.getUsername());
				ps.setString(3,  entity.getPassword());
				return ps;
			}
		}, keyHolder);
		
		entity.setId(keyHolder.getKey().longValue());
		
	}

	@Override
	public void update(User entity) {

		// Implementar UPDATE CUSTOMER

		// Implementado mediante sql y par�metros vararg
		/*
		this.jdbcTemplate.update(UPDATE_CUSTOMER, 
				entity.getCustomer().getName(), 
				entity.getCustomer().getLastName(),
				entity.getCustomer().getId()); */

		// Implementado mediante sql y setteo de parametros mediante
		// PreparedStatementSetter		
		this.jdbcTemplate.update(UPDATE_CUSTOMER,
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						// Implementar
						ps.setString(1, entity.getCustomer().getName());
						ps.setString(2, entity.getCustomer().getLastName());
						ps.setLong(3, entity.getCustomer().getId());
					}
				});

		// Implementar UPDATE USER

		// Implementado mediante sql y par�metros vararg
		this.jdbcTemplate.update(UPDATE_USER, entity.getUsername(),
				entity.getPassword(), entity.getId());
	}

	@Override
	@SneakyThrows
	public User findById(Long id) {

		User u = null;

		try {
			u = this.jdbcTemplate.queryForObject(
					SELECT_USER_CUSTOMER_WHERE_USER_ID,
					new RowMapper<User>() {
						@Override
						public User mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							// Implementar
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
							
							return usr;
						}
					}, id);

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		return u;
	}

	@Override
	public User delete(Long id) {
		User user = this.findById(id);
		return this.delete(user);
	}

	@Override
	public User delete(User entity) {
		if (entity == null)
			return entity;

		// DELETE COMPLETE RELATIONS OF USER WITH ALL TABLES

		// Pasar par�metros a update
		this.jdbcTemplate.update(DELETE_ACCOUNT_WHERE_CUSTOMER_ID,
				new Object[] { entity.getCustomer().getId() });

		// Pasar par�metros a update
		this.jdbcTemplate.update(DELETE_USER_WHERE_USER_ID, 
				new Object[] { entity.getId() });

		// Pasar par�metros a update
		this.jdbcTemplate.update(DELETE_CUSTOMER_WHERE_CUSTOMER_ID,
				new Object[] { entity.getCustomer().getId()});

		return entity;
	}

	@Override
	public List<User> findAll() {

		List<User> userList = null;
		
		
		userList = this.jdbcTemplate.query(SELECT_ALL_USER_CUSTOMER, 
				new UserRowMapper()); 

		// FIND COMPLETE ALL USER (WITH CUSTOMER)
		// Implementar mediante ResultSetExtractor		
	
		// userList = this.jdbcTemplate.query(SELECT_ALL_USER_CUSTOMER,
		// 		new ResultSetExtractor<List<User>>() {
			
		// 			private UserRowMapper userRowMapper = new UserRowMapper();

		// 			@Override
		// 			public List<User> extractData(ResultSet rs)
		// 					throws SQLException, DataAccessException {

		// 				// Implementar
		// 				List<User> listUsr = new ArrayList<>();
						
		// 				int i = 0;
		// 				while(rs.next()){
		// 					User u = userRowMapper.mapRow(rs, i++);
		// 					listUsr.add(u);
		// 				}
						
		// 				return listUsr;
		// 			}

		// 		});

		return userList;
	}

}
