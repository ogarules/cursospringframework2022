package com.example.demo.ejercicio4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MoviesSpringTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		applicationContext = new ClassPathXmlApplicationContext("spring/ejercicio4/beans.xml");
	}

	@Test
	public void moviesSpringTest() {

		log.info("Testing movie service");

		MovieListener movieListener = (MovieListener) applicationContext.getBean("movieListenerBean");
		Movie movie = movieListener.buscarPelicula("Titanic");

		Assert.assertNotNull(movie);
		Assert.assertNotNull("Titanic", movie.getTitulo());
	}
}
