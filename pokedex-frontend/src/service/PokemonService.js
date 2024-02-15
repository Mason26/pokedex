/* eslint-disable react-hooks/rules-of-hooks */
import React, { useLayoutEffect, useRef, useState } from "react";
import PokeballLoadingSpinner from "../components/PokeballLoadingSpinner";
import axios from "axios";
import Button from "@mui/material/Button";

const api = axios.create({
  baseURL: "https://pokeapi.co/api/v2/pokemon/",
});

// function goUpperCase({name}) {
//   name.
// }

export default function PokemonService({ pokemon }) {
  const [data, setData] = useState(null);
  const [image, setImage] = useState(null);
  const [loading, setLoading] = useState(false);

  async function getAllData() {
    setLoading(true);
    console.log(loading);

    let url = pokemon.toLowerCase();

    let resData = await api.get(url);

    let imageData = await api.get(resData.data.forms[0].url);

    setData(resData.data);
    setImage(imageData.data);

    setLoading(false);
    console.log(loading);
  }

  // async function fetchPokemon() {
  //   let url = pokemon.toLowerCase();

  //   await api.get(url).then((res) => {
  //     setData(res.data);
  //     return res.data;
  //   });
  // }

  // async function fetchPokemonImage(resData) {
  //   await api.get(resData.forms[0].url).then((res) => {
  //     setImage(res);
  //     return res.data;
  //   });
  // }

  return (
    <div>
      <Button
        variant="contained"
        onClick={getAllData}
        className="search-button"
      >
        Search
      </Button>
      {data ? (
        <div className="pokemon-card">
          <div className="pokemon-name">{data.name}</div>
          <div className="ability-container">
            {data.abilities.map((ability) => {
              console.log(ability);
              return <div>{ability.ability.name}</div>;
            })}
          </div>
          {image ? <img src={image.sprites.front_default} /> : <div></div>}
        </div>
      ) : (
        <div>{loading && <PokeballLoadingSpinner />}</div>
      )}
    </div>
  );
}
