import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {PokemonResponse} from '../../model/pokemonResponse';
import {Card} from '../../model/card';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PokemonType} from './pokemon-card/pokemon-card.component';

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

  private buildPokeQuery(form: FormGroup | null): string {
    let qString = 'q=set.id:base1 ';
    if (form === null || !form.valid) {
      return 'q=set.id:base1&orderBy=name';
    }
    if (form.value.name !== '') {
      qString += 'name:' + form.value.name + '* ';
    }

    if (form.value.cardType.length > 0) {
      if (form.value.cardType.length === 1) {
        qString += 'supertype:' + form.value.cardType[0] + ' ';
      } else {
        qString += '(supertype:';
        form.value.cardType.forEach((type:any, index:number) => {
          if (index === 0) {
            qString += '' + type + ' ';
          } else {
            qString += ' OR supertype:' + type + ' ';
          }
        })
        qString += ')'
      }
    }

    qString += '&orderBy=name';
    console.log('queryString:', qString);
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
    console.log('ding dong');
    if (!form.valid){
      console.log('form invalid:', form.value);
      this.cards = this.allCards;
      return;
    }
    console.log('form: ', form);
    this.cards = this.allCards;
    if (form.value.name) {
      this.cards = this.cards.filter((card) => {
        return card.name.indexOf(form.value.name[0]) !== -1;
      });
    }
    if (form.value.cardType) {
      if (typeof form.value.cardType[0] === 'undefined') {
        this.cards = this.allCards;
      } else {
        this.cards = this.cards.filter((card) => {
          return form.value.cardType.includes(card.supertype);
        });
      }
    }

    console.log(this.cards);
  }

  getCards(formData: FormGroup | null): void {
    this.httpClient.get<PokemonResponse>(POKE_BASE_CARDS_API + '?' + this.buildPokeQuery(formData))
      .subscribe((response) => {
        console.log('cards are:', response);
        this.cards = response.data;
        this.allCards = this.cards;
      });
  }

  trackByFn(index: number, item: any): number {
    return index;
  }

}
