package com.example.pokedex.client;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;
import com.example.pokedex.domain.PokemonDTO;

@SpringBootTest
class RestClientTest {

    private PokemonRestClient restClient;

    @Autowired
    public void setUp() throws Exception {
        restClient = new PokemonRestClient(new RestTemplate(), new URI("https://pokeapi.co/api/v2/"));
    }

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_HittingPokeApi_PokeApiIsHit() throws Exception {
        PokemonDTO expected = new PokemonDTO("gengar");
        String pokemonName = expected.getName();
        PokemonDTO actual = restClient.getPokemonByIdentifier(pokemonName);
        assertEquals(expected.getName(), actual.getName());
    }

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_retrievingBidoof_BidoofIsRetrieved() throws Exception{
        PokemonDTO expected = new PokemonDTO("bidoof");
        String pokemonName = expected.getName();
        PokemonDTO actual = restClient.getPokemonByIdentifier(pokemonName);
        assertEquals(expected.getName(), actual.getName());
    }

    
    @Disabled("Integration test - Inable to test again")
	@Test
	void test_GetPokemonByName_PokemonIsReturned() throws Exception{
        String expected = "clefairy";
        PokemonDTO pokemon = restClient.getPokemonByIdentifier(expected);
        String actual = pokemon.getName();
        assertEquals(expected, actual);
	}

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_GetPokemonById_PokemonIsReturned() throws Exception{
        String expected = "clefairy";
        PokemonDTO pokemon = restClient.getPokemonByIdentifier(35);
        String actual = pokemon.getName();
        assertEquals(expected, actual);
    }

    @Disabled("Integration test - Inable to test again")
    @Test
    void test_GetGengarByName_GengarIsReturned() throws Exception {
        String expected = "gengar";
        PokemonDTO pokemon = restClient.getPokemonByIdentifier(expected);
        String actual = pokemon.getName();
        assertEquals(expected, actual);
    }

}
