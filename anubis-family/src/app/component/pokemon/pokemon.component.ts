import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {PokemonResponse} from '../../model/pokemonResponse';
import {Card} from '../../model/card';

const POKE_BASE_CARDS_API: string = 'https://api.pokemontcg.io/v2/cards';
// https://docs.pokemontcg.io/
@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.less']
})
export class PokemonComponent implements OnInit {

  cards: Card[] = [];
  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getCards();
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
