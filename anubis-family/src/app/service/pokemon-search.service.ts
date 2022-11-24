import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';
import {Observable} from 'rxjs';
import PokemonQueryBuilder from "../util/PokemonQueryBuilder";

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

  getCards(page: number = 1, pageSize: number = 10, formData: FormGroup | null): Observable<any> {
    page = page + 1;
    return this.httpClient.get<any>(POKE_BASE_CARDS_API + '?' + PokemonQueryBuilder.buildPokeQuery(page, pageSize, formData))
  }
}
