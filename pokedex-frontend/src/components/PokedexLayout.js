import React, { useState, Fragment } from "react";
import PokemonService from "../service/PokemonService";
import TextField from "@mui/material/TextField";
//I think this is more the default layout. Can probably take this out
export default function PokedexLayout(props) {
  let [pokemonName, setPokemonName] = useState("");
  //need to take button out of service and put it here
  return (
    <Fragment>
      <div className="search-container">
        <TextField
          id="outlined-basic"
          label="Enter Pokemon name"
          variant="outlined"
          onChange={(event) => setPokemonName(event.target.value)}
          className="pokemon-input-name"
        />
      </div>
      <PokemonService pokemon={pokemonName} />
    </Fragment>
  );
}
