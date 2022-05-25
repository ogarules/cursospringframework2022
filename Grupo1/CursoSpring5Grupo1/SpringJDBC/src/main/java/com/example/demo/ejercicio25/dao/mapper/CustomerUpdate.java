package com.example.demo.ejercicio25.dao.mapper;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class CustomerUpdate extends SqlUpdate {
    
    private static final String UPDATE = "UPDATE SPRING_DATA_CUSTOMER_TBL "
            + "SET NAME = ?, "
            + "LAST_NAME = ? "
            + "WHERE CUSTOMER_ID = ?";
    
    public CustomerUpdate(DataSource dataSoruce) {
        super(dataSoruce, UPDATE);

        declareParameter(new SqlParameter("NAME", Types.VARCHAR));
        declareParameter(new SqlParameter("LAST_NAME", Types.VARCHAR));
        declareParameter(new SqlParameter("CUSTOMER_ID", Types.INTEGER));

        compile();
    }

    public int execute(Long id, String name, String lastName) {
        return update(name, lastName, id);
    }
}
