package com.example.pokedex.client;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.pokedex.domain.PokemonDTO;
import com.example.pokedex.exceptions.PokemonNotFoundException;

@Component
public class PokemonRestClient extends RestClient<PokemonDTO> {

    private static final String url = "pokemon/";

    public PokemonRestClient(RestTemplate restTemplate, @Qualifier("pokeApiBaseUrl") URI resourceUri) {
        super(restTemplate, resourceUri);
    }

    public PokemonDTO getPokemonByIdentifier(Object pokemonIdentifier) {
        return Optional.ofNullable(get(pokemonIdentifier)).orElseThrow(PokemonNotFoundException::new);
    }

    private PokemonDTO get(Object pokemonIdentifier) {
        try{
            return restTemplate.getForObject(resourceUri + url + String.valueOf(pokemonIdentifier), PokemonDTO.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new PokemonNotFoundException("Pokemon " + pokemonIdentifier + " was not found.");
            }
            else {
                throw new RuntimeException(ex.getMessage());
            }
        } 
    }    
}
