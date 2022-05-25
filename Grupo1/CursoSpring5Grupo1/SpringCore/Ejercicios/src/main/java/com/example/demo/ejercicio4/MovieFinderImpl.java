package com.example.demo.ejercicio4;

public class MovieFinderImpl implements IMovieFinder {

    @Override
    public Movie find(String title) {
        return Movie.builder()
                    .titulo(title)
                    .build();
    }
}