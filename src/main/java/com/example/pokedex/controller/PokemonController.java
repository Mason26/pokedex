package com.example.pokedex.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokedex.domain.PokemonDTO;
import com.example.pokedex.service.PokemonService;

// @RequestMapping(value = "/api/pokedex/pokemon/", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public ResponseEntity<PokemonDTO> getPokemon(@RequestParam("pokemonIdentifier") Object pokemonIdentifier) {
        PokemonDTO pokemon = pokemonService.getPokemon(pokemonIdentifier);
        if (pokemon != null) {
            return ResponseEntity.ok(pokemon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }    
}
