package com.example.demo.ejercicio25.dao.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.ejercicio25.dao.IAccountDAO;
import com.example.demo.ejercicio25.dao.springjdbc.GenericSpringJdbcDAO;
import com.example.demo.ejercicio25.domain.Account;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.model.CustomDate;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Profile({ "h2-in-memory", "h2-local", "mysql" })
//@Transactional(isolation=Isolation.READ_COMMITTED, propagation= Propagation.REQUIRED)
public class AccountSpringJdbcDAO extends GenericSpringJdbcDAO<Account, Long>
		implements IAccountDAO {

	private static final String SELECT_ALL_ACCOUNT_WHERE_CUSTOMER_ID = "SELECT * FROM SPRING_DATA_ACCOUNT_TBL WHERE FK_CUSTOMER_ID = ?";
	private static final String SELECT_ALL_ACCOUNT = "SELECT * FROM SPRING_DATA_ACCOUNT_TBL";
	private static final String SELECT_ACCOUNT = "SELECT * FROM SPRING_DATA_ACCOUNT_TBL WHERE ACCOUNT_ID = ?";

	private static final String INSERT_ACCOUNT = "INSERT INTO SPRING_DATA_ACCOUNT_TBL(FK_CUSTOMER_ID,ACCOUNT_NUMBER,CREATED_DATE,BALANCE) VALUES (:fkCustomerId, :accountNumber, :createdDate, :balance)";

	private static final String UPDATE_ACCOUNT_WHERE_CUSTOMER_ID = "UPDATE SPRING_DATA_ACCOUNT_TBL SET ACCOUNT_NUMBER = ?, CREATED_DATE = ?, BALANCE = ? WHERE FK_CUSTOMER_ID = ?";

	private static final String DELETE_ACCOUNT = "DELETE FROM SPRING_DATA_ACCOUNT_TBL WHERE ACCOUNT_ID = ?";

//	@Transactional(readOnly=true)
	@Override
	public List<Account> findByCustomerId(Long id) {

		List<Account> a = null;

		try {
			a = this.jdbcTemplate.query(
                SELECT_ALL_ACCOUNT_WHERE_CUSTOMER_ID,
					new RowMapper<Account>() {
						@Override
						public Account mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							// Implementar
							Account usr = new Account();
							usr.setId(rs.getLong("ACCOUNT_ID"));
							usr.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
							usr.setBalance(rs.getBigDecimal("BALANCE"));
                            usr.setCreatedDate(new CustomDate(rs.getDate("CREATED_DATE").getTime()));
							
							Customer customer = new Customer();
                            customer.setId(rs.getLong("FK_CUSTOMER_ID"));
							
                            usr.setCustomer(customer);
							
							return usr;
						}
					}, id);

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		return a;
	}

	@Override
    public void insert(Account entity) {
        // INSERT CUSTOMER
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        // Implementar Settear parametros a parameterSource
        parameterSource.addValue("fkCustomerId", entity.getCustomer().getId());
        parameterSource.addValue("accountNumber", entity.getAccountNumber());
        parameterSource.addValue("createdDate", entity.getCreatedDate());
        parameterSource.addValue("balance", entity.getBalance());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Implementar pasar argumentos a update
        this.namedJdbcTemplate.update(INSERT_ACCOUNT, parameterSource, keyHolder);

        entity.setId(keyHolder.getKey().longValue());

    }

	@Override
	public void update(Account entity) {
		// Implementado mediante sql y par�metros vararg
		this.jdbcTemplate.update(UPDATE_ACCOUNT_WHERE_CUSTOMER_ID, entity.getAccountNumber(),
				entity.getCreatedDate(), entity.getBalance(), entity.getCustomer().getId());
	}

//	@Transactional(readOnly=true)
	@Override
	public Account findById(Long id) {
		Account account = null;

		// FIND ACCOUNT BY ID
		try {

			account = this.jdbcTemplate.queryForObject(
                SELECT_ACCOUNT,
					new RowMapper<Account>() {
						@Override
						public Account mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							// Implementar
							Account usr = new Account();
							usr.setId(rs.getLong("ACCOUNT_ID"));
							usr.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
							usr.setBalance(rs.getBigDecimal("BALANCE"));
                            usr.setCreatedDate(new CustomDate(rs.getDate("CREATED_DATE").getTime()));
							
							Customer customer = new Customer();
                            customer.setId(rs.getLong("FK_CUSTOMER_ID"));
							
                            usr.setCustomer(customer);
							
							return usr;
						}
					}, id);

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		return account;
	}

	@Override
	public Account delete(Long id) {
		Account account = this.findById(id);
		return this.delete(account);
	}

	@Override
	public Account delete(Account entity) {
		if (entity == null)
			return entity;

		this.jdbcTemplate.update(DELETE_ACCOUNT,
				new Object[] { entity.getId() });

		return entity;
	}

//	@Transactional(readOnly=true)
	@Override
	public List<Account> findAll() {
        List<Account> a = null;

		try {
			a = this.jdbcTemplate.query(
                SELECT_ALL_ACCOUNT,
					new RowMapper<Account>() {
						@Override
						public Account mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							// Implementar
							Account usr = new Account();
							usr.setId(rs.getLong("ACCOUNT_ID"));
							usr.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
							usr.setBalance(rs.getBigDecimal("BALANCE"));
                            usr.setCreatedDate(new CustomDate(rs.getDate("CREATED_DATE").getTime()));
							
							Customer customer = new Customer();
                            customer.setId(rs.getLong("FK_CUSTOMER_ID"));
							
                            usr.setCustomer(customer);
							
							return usr;
						}
					});

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		return a;
	}

}
