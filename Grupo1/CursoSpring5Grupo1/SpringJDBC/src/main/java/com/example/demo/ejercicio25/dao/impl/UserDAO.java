package com.example.demo.ejercicio25.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.ejercicio25.dao.IUserDAO;
import com.example.demo.ejercicio25.dao.rowmapper.UserRowMapper;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"h2-in-memory", "h2-local", "mysql"})
public class UserDAO extends GenericSpringJdbcDAO<User, Long> implements IUserDAO {

    private static final String INSERT_CUSTOMER = "INSERT INTO SPRING_DATA_CUSTOMER_TBL(NAME,LAST_NAME) VALUES(?, ?)";
    private static final String INSERT_USER = "INSERT INTO SPRING_DATA_USER_TBL(FK_CUSTOMER_ID,USERNAME,PASSWORD) VALUES(?,?,?)";

    private static final String UPDATE_CUSTOMER = "UPDATE SPRING_DATA_CUSTOMER_TBL SET NAME = ?, LAST_NAME=? WHERE CUSTOMER_ID = ?";
    private static final String UPDATE_USER = "UPDATE SPRING_DATA_USER_TBL SET USERNAME=?, PASSWORD=? WHERE USER_ID=?";

    private static final String DELETE_ACCOUNT = "DELETE FROM SPRING_DATA_ACCOUNT_TBL WHERE FK_CUSTOMER_ID=?";
    private static final String DELETE_USER = "DELETE FROM SPRING_DATA_USER_TBL WHERE USER_ID=?";
    private static final String DELETE_CUSTOMER = "DELETE FROM SPRING_DATA_CUSTOMER_TBL WHERE CUSTOMER_ID=?";

    private static final String SELECT_USER_CUSTOMER_WHERE_USER_ID = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL INNER JOIN SPRING_DATA_USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID WHERE USER_ID = ?";
    private static final String SELECT_ALL_USER_CUSTOMER = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL INNER JOIN SPRING_DATA_USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID";
   
    @Override
    public void insert(User entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER, new String[] { "CUSTOMER_ID" });

                ps.setString(1, entity.getCustomer().getName());
                ps.setString(2, entity.getCustomer().getLastName());

                return ps;
            }
        }, keyHolder);

        entity.getCustomer().setId(keyHolder.getKey().longValue());

        keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(INSERT_USER, new String[] { "USER_ID" });

                ps.setLong(1, entity.getCustomer().getId());
                ps.setString(2, entity.getUsername());
                ps.setString(3, entity.getPassword());

                return ps;
            }

        }, keyHolder);

        entity.setId(keyHolder.getKey().longValue());

    }
    
    @Override
    public void update(User entity) {
        this.jdbcTemplate.update(UPDATE_CUSTOMER, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, entity.getCustomer().getName());
                ps.setString(2, entity.getCustomer().getLastName());
                ps.setLong(3, entity.getCustomer().getId());
            }
        });

        this.jdbcTemplate.update(UPDATE_USER, entity.getUsername(), entity.getPassword(), entity.getId());

    }
    
    @Override
    public User findById(Long id) {
        User u;

        try {
            u = this.jdbcTemplate.queryForObject(SELECT_USER_CUSTOMER_WHERE_USER_ID, new RowMapper<User>(){

                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
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

                    return user;
                }

            }, id);
        }
        catch (EmptyResultDataAccessException ex) {
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

        this.jdbcTemplate.update(DELETE_ACCOUNT, entity.getCustomer().getId());
        this.jdbcTemplate.update(DELETE_USER, entity.getId());
        this.jdbcTemplate.update(DELETE_CUSTOMER, entity.getCustomer().getId());

        return entity;
    }
    
    @Override
    public List<User> findAll() {
        List<User> users = null;

        users = this.jdbcTemplate.query(SELECT_ALL_USER_CUSTOMER, new UserRowMapper());

        return users;
    }
    
}
