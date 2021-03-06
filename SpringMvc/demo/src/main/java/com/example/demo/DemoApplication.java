package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {

	// @Bean
    // public MessageSource messageSource() {
    //     ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    //     messageSource.setBasename("classpath:messages");
    //     messageSource.setDefaultEncoding("UTF-8");
    //     return messageSource;
    // }

    // @Bean
	// public LocalValidatorFactoryBean validator() {
	// 	LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	// 	bean.setValidationMessageSource(messageSource());
	// 	return bean;
	// }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
