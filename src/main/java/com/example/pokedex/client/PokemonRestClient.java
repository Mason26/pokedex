package com.example.pokedex.client;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import com.example.pokedex.domain.PokemonDTO;

public class PokemonRestClient extends RestClient<PokemonDTO> {

    private static final String url = "pokemon/";

    public PokemonRestClient(RestTemplate restTemplate, @Qualifier("pokeApiBaseUrl") URI resourceUri) {
        super(restTemplate, resourceUri);
    }

    public PokemonDTO getPokemonByIdentifier(Object pokemonIdentifier) throws Exception {
        return Optional.ofNullable(get(pokemonIdentifier)).orElseThrow(Exception::new);
    }

    private PokemonDTO get(Object pokemonIdentifier) {
        return restTemplate.getForObject(resourceUri + url + String.valueOf(pokemonIdentifier), PokemonDTO.class);
    }    
}
