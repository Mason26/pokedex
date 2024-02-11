package com.example.pokedex.exceptions;


public class PokemonNotFoundException extends RuntimeException {

    public PokemonNotFoundException() {
        super("Pokemon not found");
    }

    public PokemonNotFoundException(String message) {
        super(message);
    }
}
