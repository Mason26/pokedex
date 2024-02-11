package com.example.pokedex.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.pokedex.domain.PokemonDTO;
import com.example.pokedex.service.PokemonService;

@WebMvcTest
public class PokemonControllerIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Test
    void test_shouldGetBidoof() throws Exception {
        when(pokemonService
            .getPokemon("bidoof"))
            .thenReturn(new PokemonDTO("bidoof"));

        mockMvc.perform(get("/pokemon?pokemonIdentifier=bidoof"))
            .andDo(print())
            .andExpect(status().isOk());

        verify(pokemonService).getPokemon("bidoof");
    }

}
