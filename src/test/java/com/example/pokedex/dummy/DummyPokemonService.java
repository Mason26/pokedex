package com.example.pokedex.dummy;
import com.example.pokedex.domain.PokemonDTO;
import com.example.pokedex.service.PokemonService;

public class DummyPokemonService extends PokemonService {

    public DummyPokemonService() {
        super(null);
    }

    @Override
    public PokemonDTO getPokemon(Object pokemonIdentifier) throws Exception {
        return new PokemonDTO("gengar");
    }

}