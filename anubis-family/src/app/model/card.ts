import {PokemonType} from '../component/pokemon/pokemon-card/pokemon-card.component';

export interface Card {
  name: string;
  showDetails: string;
  images: {
    small: string;
  },
  attacks: Attack[],
  hp: string,
  types: PokemonType[],
  supertype: 'Trainer' | 'Energy' | 'Pokémon'
}

export interface Attack {
  name: string;
  damage: string;
}
