import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {BehaviorSubject, Observable, of} from "rxjs";
import {PokemonSearchService} from "../service/pokemon-search.service";
import {catchError, finalize} from "rxjs/operators";


export default class PokemonDataSource extends DataSource<any> {

  private cardsSubject: BehaviorSubject<any> = new BehaviorSubject<any>([]);
  private loadingSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  public loading$ = this.loadingSubject.asObservable();

  constructor(private searchService: PokemonSearchService) {
    super();
  }

  connect(collectionViewer: CollectionViewer): Observable<any> {
    console.log('connected!:', collectionViewer);
    return this.cardsSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.loadingSubject.complete();
    this.cardsSubject.complete();
  }

  getCards(): void {
    this.loadingSubject.next(true);

    this.searchService.getCards(null)
      .pipe(
        catchError(() => of([])),
        finalize(() => this.loadingSubject.next(false))
      )
      .subscribe((data) => {
        console.log('loading data...', data);
        this.cardsSubject.next(data.data);
    })
  }

}
