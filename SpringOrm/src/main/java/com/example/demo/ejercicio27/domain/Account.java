package com.example.demo.ejercicio27.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.ejercicio27.hibernate.types.DateTimeUserType;
import com.example.demo.ejercicio27.model.CustomDate;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SPRING_DATA_ACCOUNT_TBL")
@ToString(exclude = "customer")
@EqualsAndHashCode(exclude = "customer")
@TypeDefs({@TypeDef(name="dateTimeUserType",typeClass = DateTimeUserType.class)})
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CUSTOMER_ID")
    private Customer customer;

    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name="BALANCE")
    private BigDecimal balance;

    @Column(name = "CREATED_DATE")
    @Type(type = "dateTimeUserType")
    private CustomDate createdDate;

}
