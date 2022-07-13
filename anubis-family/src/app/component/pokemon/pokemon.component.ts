import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PokemonSearchService} from '../../service/pokemon-search.service';
import PokemonDataSource from "../../util/PokemonDataSource";
import {Card} from "../../model/card";

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
  ds: PokemonDataSource = new PokemonDataSource(this.searchService);

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
    this.ds.getCards();
    // this.getCards(null);
  }

  doSearch(form: FormGroup): void {
    // if (!form.valid){
    //   this.getCards(null);
    //   return;
    // }
    //
    // this.getCards(form);
  }

  getCards(formData: FormGroup | null): void {
    // this.searchService.getCards(formData)
    //   .subscribe((response) => {
    //     console.log('response', response);
    //     this.cards = response;
    //     this.allCards = this.cards;
    //     this.ds = new PokemonDataSource(this.searchService);
    //     console.log('this.ds:', this.ds);
    //   });
  }

  trackByFn(index: number): number {
    return index;
  }

}
