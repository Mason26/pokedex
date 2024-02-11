package com.example.pokedex.client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.net.URI;
import java.net.URISyntaxException;

import com.example.pokedex.domain.PokemonDTO;
import org.springframework.test.web.client.MockRestServiceServer;

class PokemonRestClientTest {

    @Autowired
    MockRestServiceServer server;

    @Autowired
    private PokemonRestClient restClient;

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_HittingPokeApi_PokeApiIsHit() {
        PokemonDTO expected = new PokemonDTO("gengar");
        String pokemonName = expected.getName();
        PokemonDTO actual = restClient.getPokemonByIdentifier(pokemonName);
        assertEquals(expected.getName(), actual.getName());
        assertFalse(true);
    }

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_retrievingBidoof_BidoofIsRetrieved() {
        PokemonDTO expected = new PokemonDTO("bidoof");
        String pokemonName = expected.getName();
        PokemonDTO actual = restClient.getPokemonByIdentifier(pokemonName);
        assertEquals(expected.getName(), actual.getName());
        assertFalse(true);
    }

    
    @Disabled("Integration test - Inable to test again")
	@Test
	void test_GetPokemonByName_PokemonIsReturned() {
        String expected = "clefairy";
        PokemonDTO pokemon = restClient.getPokemonByIdentifier(expected);
        String actual = pokemon.getName();
        assertEquals(expected, actual);
        assertFalse(true);
	}

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_GetPokemonById_PokemonIsReturned() {
        String expected = "clefairy";
        PokemonDTO pokemon = restClient.getPokemonByIdentifier(35);
        String actual = pokemon.getName();
        assertEquals(expected, actual);
        assertFalse(true);
    }

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_GetGengarByName_GengarIsReturned() {
        String expected = "gengar";
        PokemonDTO pokemon = restClient.getPokemonByIdentifier(expected);
        String actual = pokemon.getName();
        assertEquals(expected, actual);
        assertFalse(true);
    }

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_ExceptionIsThrown_ExceptionIsThrown() throws URISyntaxException {
        restClient = new PokemonRestClient(new RestTemplate(), new URI("https://pokeapi.co/api/v2/"));
        String expected = "sdfsdfs";
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            restClient.getPokemonByIdentifier(expected);
        });
        assertFalse(true);
    }

}
