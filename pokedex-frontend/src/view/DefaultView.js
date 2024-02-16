import React, { useState, Fragment } from "react";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import PokeballLoadingSpinner from "../components/PokeballLoadingSpinner";
import axios from "axios";

const api = axios.create({
  baseURL: "https://pokeapi.co/api/v2/pokemon/",
});

export default function DefaultView(props) {
  const [pokemonName, setPokemonName] = useState("");
  const [data, setData] = useState(null);
  const [image, setImage] = useState(null);
  const [loading, setLoading] = useState(false);
  const [showMoves, setShowMoves] = useState(false);

  async function getAllData() {
    setLoading(true);
    let url = pokemonName.toLowerCase();

    let resData = await api.get(url);

    let imageData = await api.get(resData.data.forms[0].url);

    setData({ generalData: { ...resData.data, ...imageData.data } });

    setLoading(false);
  }

  function getAbilities() {
    return (
      <div className="ability-container">
        {data.generalData.abilities.map((ability, index) => {
          return <div key={index}>{formatText(ability.ability.name)}</div>;
        })}
      </div>
    );
  }

  function getSprites() {
    return (
      <div className="sprite-container">
        {data.generalData &&
          Object.keys(data.generalData.sprites)
            .reverse()
            .map((sprite, index) => {
              if (data.generalData.sprites[sprite] !== null) {
                return (
                  <div key={index}>
                    <img src={data.generalData.sprites[sprite]} alt="Pokemon" />
                    <div className="sprite-name">{formatText(sprite)}</div>
                  </div>
                );
              }
            })}
      </div>
    );
  }

  function searchContainer() {
    return (
      <div className="search-container">
        <TextField
          id="outlined-basic"
          label="Enter Pokemon name"
          variant="outlined"
          onChange={(event) => setPokemonName(event.target.value)}
          className="pokemon-input-name"
        />
        <Button variant="contained" onClick={getAllData}>
          Search
        </Button>
      </div>
    );
  }

  function formatText(text) {
    let newString = text;
    newString = text.replaceAll("-", " ");
    newString = newString.replaceAll("_", " ");
    return newString;
  }

  function getMoves() {
    return (
      <div>
        {data.generalData.moves.map((move, index) => {
          return (
            <div key={index} className="move-container">
              {formatText(move.move.name)}
            </div>
          );
        })}
      </div>
    );
  }

  return (
    <div className="default-layout">
      {searchContainer()}
      {data ? (
        <div className="pokemon-card">
          <div className="pokemon-name">{data.generalData.name}</div>
          <br />
          {getAbilities()}
          {getSprites()}
          <Button variant="contained" onClick={() => setShowMoves(!showMoves)}>
            Moves
          </Button>
          {showMoves === false ? <Fragment></Fragment> : getMoves()}
        </div>
      ) : (
        <div>{loading && <PokeballLoadingSpinner />}</div>
      )}
    </div>
  );
}
