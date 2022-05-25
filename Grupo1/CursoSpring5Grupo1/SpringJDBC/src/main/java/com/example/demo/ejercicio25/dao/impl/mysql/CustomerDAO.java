package com.example.demo.ejercicio25.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.ejercicio25.dao.ICustomerDAO;
import com.example.demo.ejercicio25.dao.impl.GenericSpringJdbcDAO;
import com.example.demo.ejercicio25.dao.mapper.CustomerUpdate;
import com.example.demo.ejercicio25.dao.mapper.UserEntity;
import com.example.demo.ejercicio25.dao.mapper.UserUpdate;
import com.example.demo.ejercicio25.dao.rowmapper.CustomerRowMapper;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"mysql"})
public class CustomerDAO extends GenericSpringJdbcDAO<Customer, Long> implements ICustomerDAO, InitializingBean {

    private SimpleJdbcCall readCustomerProcedure;
    private SimpleJdbcInsert insertCustomer;
    private SimpleJdbcInsert insertUser;

    private CustomerUpdate customerUpdate;
    private UserUpdate userUpdate;

    private static final String SELECT_ALL = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL, SPRING_DATA_USER_TBL WHERE CUSTOMER_ID = FK_CUSTOMER_ID";

    @Override
    public void afterPropertiesSet() throws Exception {
        this.customerUpdate = new CustomerUpdate(this.jdbcTemplate.getDataSource());
        this.userUpdate = new UserUpdate(this.jdbcTemplate.getDataSource());
        
        this.insertCustomer = new SimpleJdbcInsert(this.jdbcTemplate)
                .withTableName("SPRING_DATA_CUSTOMER_TBL")
                .usingGeneratedKeyColumns("CUSTOMER_ID");

        this.insertUser = new SimpleJdbcInsert(this.jdbcTemplate)
                .withTableName("SPRING_DATA_USER_TBL")
                .usingGeneratedKeyColumns("USER_ID");
        
        this.readCustomerProcedure = new SimpleJdbcCall(this.jdbcTemplate.getDataSource())
                .withProcedureName("read_customer_user");
    }

    @Override
    public void insert(Customer entity) {
        KeyHolder keyHolder = insertCustomer.executeAndReturnKeyHolder(new BeanPropertySqlParameterSource(entity));
        entity.setId(keyHolder.getKey().longValue());

        UserEntity user = UserEntity.map(entity.getUser());

        keyHolder = insertUser.executeAndReturnKeyHolder(new BeanPropertySqlParameterSource(user));
        entity.getUser().setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Customer entity) {
        customerUpdate.execute(entity.getId(), entity.getName(), entity.getLastName());
        userUpdate.execute(entity.getUser().getId(), entity.getUser().getUsername(), entity.getUser().getPassword());       
    }

    @Override
    public Customer findById(Long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("in_customerId", id);

        Map<String, Object> out = readCustomerProcedure.execute(parameterSource);

        if ((Integer) out.get("#update-count-1") == 0) {
            return null;
        }

        User u = new User();
        Customer c = new Customer();

        u.setId(new Long((Integer) out.get("out_user_id")));
        u.setPassword((String) out.get("out_password"));
        u.setUsername((String) out.get("out_username"));

        c.setId(new Long((Integer) out.get("out_customer_id")));
        c.setLastName((String) out.get("out_last_name"));
        c.setName((String) out.get("out_name"));

        c.setUser(u);
        u.setCustomer(c);

        return c;
    }

    @Override
    public Customer delete(Long id) {
        Customer customer = this.findById(id);
        return this.delete(customer);
    }

    @Override
    public Customer delete(Customer entity) {
        final String DELETE_ACCOUNT = "DELETE FROM SPRING_DATA_ACCOUNT_TBL WHERE FK_CUSTOMER_ID = :customerId";
        final String DELETE_CUSTOMER = "DELETE FROM SPRING_DATA_CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";
        final String DELETE_USER = "DELETE FROM SPRING_DATA_USER_TBL WHERE USER_ID = :userId";

        Map<String, Object> mapParameters = new HashMap<>();
        mapParameters.put("customerId", entity.getId());
        mapParameters.put("userId", entity.getUser().getId());

        this.namedJdbcTemplate.update(DELETE_ACCOUNT, mapParameters);
        this.namedJdbcTemplate.update(DELETE_USER, mapParameters);
        this.namedJdbcTemplate.update(DELETE_CUSTOMER, mapParameters);

        return entity;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        this.namedJdbcTemplate.query(SELECT_ALL, new RowCallbackHandler() {

            private CustomerRowMapper rowMapper = new CustomerRowMapper();
            private int rowNum = 0;

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                customers.add(rowMapper.mapRow(rs, rowNum++));
            }
            
        });

        return customers;
    }  
    
}
