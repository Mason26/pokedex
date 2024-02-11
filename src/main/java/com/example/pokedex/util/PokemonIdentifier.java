package com.example.pokedex.util;

import javax.naming.NameNotFoundException;

public class PokemonIdentifier<T> {
    
    T idenifierT;

    public PokemonIdentifier(T id) {
        this.idenifierT = id;  
    }

    public String getIdenifierT() throws NameNotFoundException {
        if(this.idenifierT instanceof String) {
            return (String) idenifierT;
        }
        else if (this.idenifierT instanceof Integer) {
            return (String) idenifierT;
        }
        else {
            throw new NameNotFoundException("Invalid identifier type");
        }
    }

}
