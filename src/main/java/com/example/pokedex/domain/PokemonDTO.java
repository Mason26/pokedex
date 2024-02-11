package com.example.pokedex.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PokemonDTO
 */
public class PokemonDTO {

    private final String name;

    @JsonCreator
    public PokemonDTO(
        @JsonProperty("name") String name
        )
    {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}