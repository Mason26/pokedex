package com.example.pokedex.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.pokedex.domain.PokemonDTO;
import com.example.pokedex.service.PokemonService;

public class PokemonControllerTest {

    @SuppressWarnings("null")
    @Test
    void test_getPokemon_correctPokemonRetrieved() throws Exception {
        PokemonService pokemonService = Mockito.mock(PokemonService.class);
        when(pokemonService.getPokemon("gengar")).thenReturn(new PokemonDTO("gengar"));
        PokemonController controller = new PokemonController(pokemonService);
        assertEquals("gengar", controller.getPokemon("gengar").getBody().getName());
    }

    
    @Test()
    void test_getPokemon_pokeDoesntExist() throws Exception {
        PokemonService pokemonService = Mockito.mock(PokemonService.class);
        when(pokemonService.getPokemon("asfsdf")).thenReturn(null);
        Assertions.assertThrows(RuntimeException.class,  null);
    }
}
