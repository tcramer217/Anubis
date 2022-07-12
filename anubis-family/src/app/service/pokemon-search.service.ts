import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';
import {PokemonResponse} from '../model/pokemonResponse';
import PokemonQueryBuilder from '../util/PokemonQueryBuilder';
import {Observable} from 'rxjs';

const POKE_BASE_CARDS_API: string = 'https://api.pokemontcg.io/v2/cards';
// https://docs.pokemontcg.io/

@Injectable({
  providedIn: 'root'
})
export class PokemonSearchService {

  constructor(
    private httpClient: HttpClient,
  ) {
  }

  getCards(formData: FormGroup | null): Observable<PokemonResponse> {
    return this.httpClient.get<PokemonResponse>(POKE_BASE_CARDS_API + '?' + PokemonQueryBuilder.buildPokeQuery(formData));
  }
}
