import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PokemonSearchService} from '../../service/pokemon-search.service';
import PokemonDataSource from "../../util/PokemonDataSource";
import {Card} from "../../model/card";
import {MyDataSource} from '../../util/MyDataSource';
import {CardTypes, PokemonTypes} from "./pokemon-card/pokemon-card.component";

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PokemonComponent {

  searchForm: FormGroup;

  cardTypes: readonly string[] = CardTypes;
  pokemonTypes: readonly string[] = PokemonTypes;

  ds: PokemonDataSource;

  constructor(
    private httpClient: HttpClient,
    private formBuilder: FormBuilder,
    private searchService: PokemonSearchService
  ) {
    this.searchForm = this.formBuilder.group({
      name: ['', [Validators.maxLength(25)]],
      cardType: [[],],
      pokemonType: [[],],
    });
    this.ds = new PokemonDataSource(this.searchForm, this.searchService);
  }

  doSearch(form: FormGroup): void {
    this.ds.getCards(0, 10, form, true);
  }

  trackByFn(index: number): number {
    return index;
  }

}
