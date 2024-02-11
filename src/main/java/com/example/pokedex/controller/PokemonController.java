package com.example.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pokedex.domain.PokemonDTO;
import com.example.pokedex.service.PokemonService;

// @RequestMapping(value = "/api/pokedex/pokemon/", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
public class PokemonController {

    // @Autowired
    // private PokemonService pokemonService;

    // public PokemonController(PokemonService pokemonService) {
    //     this.pokemonService = pokemonService;
    // }

    // @GetMapping(value = "{pokemonIdentifier}")
    // @GetMapping()
    // public ResponseEntity<PokemonDTO> getPokemon(@PathVariable("pokemonIdentifier") Object pokemonIdentifier) throws Exception {
    //     PokemonDTO pokemon = pokemonService.getPokemon(pokemonIdentifier);
    //     if (pokemon != null) {
    //         return ResponseEntity.ok(pokemon);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello world";
    } 
    
}
