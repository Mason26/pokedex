package com.example.pokedex.service;
import org.springframework.stereotype.Service;
import com.example.pokedex.client.PokemonRestClient;
import com.example.pokedex.domain.PokemonDTO;

@Service
public class PokemonService {

    private final PokemonRestClient pokemonRestClient;
    
    public PokemonService(PokemonRestClient pokemonRestClient) {
        this.pokemonRestClient = pokemonRestClient;
    }

    public PokemonDTO getPokemon(Object pokemonIdentifier) throws Exception {
        return pokemonRestClient.getPokemonByIdentifier(pokemonIdentifier);
    }

}
