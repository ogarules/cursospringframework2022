package com.example.demo.ejercicio27.hibernate.customtypes;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import com.example.demo.ejercicio27.models.CustomDate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class DateTimeUserType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.TIMESTAMP };
    }

    @Override
    public Class returnedClass() {
        return CustomDate.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y || !(x == null || y == null) && x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        Timestamp timeStamp = rs.getTimestamp(names[0]);
        if (rs.wasNull()) {
            return null;
        }

        return new CustomDate(timeStamp.getTime());
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.TIMESTAMP);
        }
        else {
            CustomDate customDate = (CustomDate) value;
            Timestamp timeStamp = new Timestamp(customDate.getTime());
            st.setTimestamp(index, timeStamp);
        }
        
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable)value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
    
}
