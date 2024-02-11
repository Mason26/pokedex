import React, { Component } from "react";
import PokedexLayout from "../components/PokedexLayout";

export default class DefaultView extends Component {
  render() {
    return (
      <div className="default-layout">
        <PokedexLayout />
      </div>
    );
  }
}
