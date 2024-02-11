package com.example.pokedex.dummy;
import org.springframework.stereotype.Service;

import com.example.pokedex.domain.PokemonDTO;
import com.example.pokedex.service.PokemonService;

@Service
public class DummyPokemonService extends PokemonService {

    public DummyPokemonService() {
        super(null);
    }

    @Override
    public PokemonDTO getPokemon(Object pokemonIdentifier) {
        return new PokemonDTO("gengar");
    }

}