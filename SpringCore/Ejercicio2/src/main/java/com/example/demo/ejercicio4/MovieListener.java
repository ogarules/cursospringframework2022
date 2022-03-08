package com.example.demo.ejercicio4;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieListener {

	private IMovieFinder movieFinder;

	public Movie buscarPelicula(String titulo) {
		return movieFinder.find(titulo);
	}

}
