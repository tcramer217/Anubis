import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Card} from '../../model/card';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PokemonSearchService} from '../../service/pokemon-search.service';
import {ArrayDataSource, DataSource} from '@angular/cdk/collections';

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
  ds: DataSource<Card> = new ArrayDataSource(this.allCards);

  constructor(
    private httpClient: HttpClient,
    private formBuilder: FormBuilder,
    private searchService: PokemonSearchService
  ) {
    this.searchForm = this.formBuilder.group({
      name: ['', [Validators.maxLength(25)]],
      cardType: [[],],
    });
  }

  ngOnInit(): void {
    this.getCards(null);
  }

  doSearch(form: FormGroup): void {
    if (!form.valid){
      this.getCards(null);
      return;
    }

    this.getCards(form);
  }

  // doFilter(form: FormGroup): void {
  //   console.log('doFilter:', form);
  //   if (!form.valid){
  //     console.log('forminvalid')
  //     this.cards = this.allCards;
  //     return;
  //   }
  //
  //   console.log('form.value.name', form.value.name);
  //   this.cards = this.allCards;
  //   if (form.value.name) {
  //     this.cards = this.cards.filter((card) => {
  //       console.log('card is:', card);
  //       return card.name.indexOf(form.value.name) !== -1;
  //     });
  //   }
  //   if (form.value.cardType) {
  //     if (typeof form.value.cardType[0] === 'undefined') {
  //       this.cards = this.allCards;
  //     } else {
  //       this.cards = this.cards.filter((card) => {
  //         return form.value.cardType.includes(card.supertype);
  //       });
  //     }
  //   }
  // }

  getCards(formData: FormGroup | null): void {
    this.searchService.getCards(formData)
      .subscribe((response) => {
        this.cards = response.data;
        this.allCards = this.cards;
      });
  }

  trackByFn(index: number): number {
    return index;
  }

}
