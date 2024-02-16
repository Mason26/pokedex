// import axios from "axios";

// const api = axios.create({
//   baseURL: "https://pokeapi.co/api/v2/pokemon/",
// });

// export function PokemonService({ pokemon }) {
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
//   return (
//     <div>
//       {data ? (
//         <div className="pokemon-card">
//           <div className="pokemon-name">{data.name}</div>
//           <div className="ability-container">
//             {data.abilities.map((ability) => {
//               console.log(ability);
//               return <div>{ability.ability.name}</div>;
//             })}
//           </div>
//           {image ? <img src={image.sprites.front_default} /> : <div></div>}
//         </div>
//       ) : (
//         <div>{loading && <PokeballLoadingSpinner />}</div>
//       )}
//     </div>
//   );
// }

// export default async function getAllData({ pokemon }) {
//   let url = pokemon.toLowerCase();

//   let resData = await api.get(url);

//   let imageData = await api.get(resData.data.forms[0].url);

//   let allData = { data: resData, image: imageData };

//   return allData;
// }

// export { getAllData };
