import {Component, Input, OnInit} from '@angular/core';
import {Card} from "../../../model/card";
import {animate, state, style, transition, trigger} from '@angular/animations';
import {stringifyTask} from '@angular/compiler-cli/ngcc/src/execution/tasks/utils';
// import {PokemonType} from '../../../model/pokemonType';

@Component({
  selector: 'app-pokemon-card',
  templateUrl: './pokemon-card.component.html',
  styleUrls: ['./pokemon-card.component.less'],
  animations: [
    trigger('flip', [
      // ...
      state('default', style({
        transform: 'rotateY(0deg)'
      })),
      state('flipped', style({
        transform: 'rotateY(180deg)'
      })),
      transition('default => flipped', [
        animate('1s')
      ]),
      transition('flipped => default', [
        animate('1s')
      ]),
    ]),
  ],
})
export class PokemonCardComponent implements OnInit {

  @Input()
  card: Card = {
    attacks: [],
    hp: '',
    types: ['Colorless'],
    name: 'test',
    showDetails: 'default',
    images: {
      small: ''
    },
    superType: 'Pokémon'
  };

  cardClass: string = 'colorless';

  constructor() {
  }

  ngOnInit(): void {
    if (typeof this.card.showDetails === 'undefined') {
      this.card.showDetails = 'default';
    }
    if(typeof this.card.types === 'undefined') {
      this.card.types = ['Energy'];
    }
    this.getCardHeaderClass(this.card.types[0])
  }

  getCardHeaderClass(type: PokemonType): void {
    switch (type) {
      case 'Colorless':
        this.cardClass = 'colorless';
        break;
      case 'Fire':
        this.cardClass = 'fire';
        break;
      case 'Grass':
        this.cardClass = 'grass';
        break;
      case 'Poison':
        this.cardClass = 'poison';
        break;
      case 'Psychic':
        this.cardClass = 'psychic';
        break;
      case 'Energy':
      default:
        this.cardClass = 'colorless';
        break;
    }
  }

  showDetails() {
    if (this.card.showDetails === 'default') {
      this.card.showDetails = 'flipped';
    } else if (this.card.showDetails === 'flipped') {
      this.card.showDetails = 'default';
    }
  }

}

export type PokemonType = 'Colorless' | 'Energy' | 'Fire' | 'Grass' | 'Poison' | 'Psychic';
