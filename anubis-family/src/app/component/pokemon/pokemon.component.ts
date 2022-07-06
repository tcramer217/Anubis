import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {PokemonResponse} from '../../model/pokemonResponse';
import {Card} from '../../model/card';
import {animate, state, style, transition, trigger} from "@angular/animations";

const POKE_BASE_CARDS_API: string = 'https://api.pokemontcg.io/v2/cards';
// https://docs.pokemontcg.io/
@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.less'],
  animations: [
    trigger('openClose', [
      // ...
      state('open', style({
        height: '200px',
        opacity: 1,
        backgroundColor: 'yellow'
      })),
      state('closed', style({
        height: '100px',
        opacity: 0.8,
        backgroundColor: 'blue'
      })),
      transition('open => closed', [
        animate('1s')
      ]),
      transition('closed => open', [
        animate('0.5s')
      ]),
    ]),
  ],
})
export class PokemonComponent implements OnInit {

  cards: Card[] = [];
  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getCards();
  }

  isOpen = true;

  toggle() {
    this.isOpen = !this.isOpen;
  }

  getCards(): void {
    this.httpClient.get<PokemonResponse>(POKE_BASE_CARDS_API + '?q=subtypes:basic set.id:base1&orderBy=name')
      .subscribe((response) => {
        console.log('cards are:', response);
        this.cards = response.data;
      });
  }

  trackByFn(index: number, item: any): number {
    console.log(index);
    console.log(item);
    return index;
  }

}
