import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {PokemonResponse} from '../../model/pokemonResponse';
import {Card} from '../../model/card';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

const POKE_BASE_CARDS_API: string = 'https://api.pokemontcg.io/v2/cards';
// https://docs.pokemontcg.io/

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.less'],
})
export class PokemonComponent implements OnInit {

  searchForm: FormGroup;

  cards: Card[] = [];
  allCards: Card[] = [];
  cardTypes: string[] = ['Energy', 'Trainer', 'Pokémon'];

  constructor(private httpClient: HttpClient, private formBuilder: FormBuilder) {
    this.searchForm = this.formBuilder.group({
      name: ['', [Validators.maxLength(25)]],
      cardType: [[],],
    });
  }

  ngOnInit(): void {
    this.getCards(null);
  }

  private static buildPokeQuery(form: FormGroup | null): string {
    let qString = 'q=subtypes:basic set.id:base1 ';
    if (form === null || !form.valid) {
      return 'q=set.id:base1&orderBy=name';
    }
    if (form.value.name !== '') {
      qString += 'name:' + form.value.name + '*';
    }

    qString += '&orderBy=name';
    return qString;
  }

  doSearch(form: FormGroup): void {
    if (!form.valid){
      this.getCards(null);
      return;
    }

    this.getCards(form);
  }

  doFilter(form: FormGroup): void {
    if (!form.valid){
      this.cards = this.allCards;
      return;
    }
    if (form.value.name) {
      this.cards = this.allCards.filter((card) => {
        return card.name.indexOf(form.value.name[0]) !== -1;
      });
    }
    if (form.value.cardType) {
      this.cards = this.cards.filter((card) => {
        return form.value.cardType[0] === card.supertype;
      })
    }
  }

  getCards(formData: FormGroup | null): void {
    this.httpClient.get<PokemonResponse>(POKE_BASE_CARDS_API + '?' + PokemonComponent.buildPokeQuery(formData))
      .subscribe((response) => {
        this.cards = response.data;
        this.allCards = this.cards;
      });
  }

  trackByFn(index: number): number {
    return index;
  }

}
