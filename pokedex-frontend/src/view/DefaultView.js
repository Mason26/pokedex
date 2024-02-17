import React, { useState, Fragment } from "react";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import PokeballLoadingSpinner from "../components/PokeballLoadingSpinner";
import axios from "axios";
import { Modal } from "@mui/material";
import Box from "@mui/material/Box";

const api = axios.create({
  baseURL: "https://pokeapi.co/api/v2/pokemon/",
});

export default function DefaultView(props) {
  const [pokemonName, setPokemonName] = useState("");
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [showMoves, setShowMoves] = useState(false);
  const [showAbilities, setShowAbilities] = useState(false);
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedSprite, setSelectedSprite] = useState("");

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
      <div>
        <div>Abilites</div>
        {data.generalData.abilities.map((ability, index) => {
          return (
            <div key={index} className="ability-container">
              {formatText(ability.ability.name)}
            </div>
          );
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
                  <div key={index} className="single-sprite-container">
                    <img
                      src={data.generalData.sprites[sprite]}
                      alt="Pokemon"
                      className="sprite-image"
                      onClick={() =>
                        handleModal(data.generalData.sprites[sprite])
                      }
                    />
                    <div className="sprite-name">{formatText(sprite)}</div>
                  </div>
                );
              }
            })}
        {renderModal(selectedSprite)}
      </div>
    );
  }

  function handleModal(value) {
    console.log(value);
    setSelectedSprite(value);
    setModalOpen(true);
  }

  function renderModal(sprite) {
    return (
      <div>
        <Modal
          open={modalOpen}
          onClose={() => setModalOpen(false)}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
          className="sprite-modal"
        >
          <div>
            {/* <Button>X</Button> */}
            <img src={sprite} alt="Pokemon" className="enlarged-sprite-image" />
          </div>
        </Modal>
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
        <div>Moves</div>
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
          <div className="pokemon-header">
            <div className="pokemon-name">{data.generalData.name}</div>
            <Button
              variant="contained"
              onClick={() => setShowMoves(!showMoves)}
            >
              Moves
            </Button>
            <Button
              variant="contained"
              onClick={() => setShowAbilities(!showAbilities)}
            >
              Abilities
            </Button>
          </div>
          <br />
          {getSprites()}
          <br />
          {showMoves === false ? <Fragment></Fragment> : getMoves()}

          {showAbilities === false ? <Fragment></Fragment> : getAbilities()}
        </div>
      ) : (
        <div>{loading && <PokeballLoadingSpinner />}</div>
      )}
    </div>
  );
}
