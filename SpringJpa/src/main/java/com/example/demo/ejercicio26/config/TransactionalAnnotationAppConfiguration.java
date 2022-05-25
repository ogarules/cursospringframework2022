package com.example.demo.ejercicio26.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configurable
// Habilitar Transaction Managemer
@EnableTransactionManagement(order=100)
// Habilitar AspectJ AutoProxy
@EnableAspectJAutoProxy
@ComponentScan({ "com.example.demo.ejercicio26",
		"com.example.demo.util" })
@ImportResource("classpath:spring/ejercicio26/datasource-application-context.xml")
public class TransactionalAnnotationAppConfiguration {

	@Bean
	public PlatformTransactionManager transactionManager(
			DataSource datasource) {
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(datasource);
		return dstm;
	}

}
