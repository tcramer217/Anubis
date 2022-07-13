import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {BehaviorSubject, Observable, of, Subscription} from "rxjs";
import {PokemonSearchService} from "../service/pokemon-search.service";
import {catchError, finalize} from "rxjs/operators";


export default class PokemonDataSource extends DataSource<any> {

  private _length = 102;
  private _pageSize = 50;
  private _cachedData = new Array<string>(this._length);
  private _fetchedPages = new Set<number>();
  private readonly _dataStream = new BehaviorSubject<(string | undefined)[]>(this._cachedData);
  private readonly _subscription = new Subscription();

  constructor(private searchService: PokemonSearchService) {
    super();
  }

  connect(collectionViewer: CollectionViewer): Observable<any> {
    this._subscription.add(
      collectionViewer.viewChange.subscribe(range => {
        console.log('range:', range);
        const startPage = this._getPageForIndex(range.start);
        const endPage = this._getPageForIndex(range.end - 1);
        console.log('startPage: {}, endPage: {}', startPage, endPage);
        for (let i = startPage; i <= endPage; i++) {
          this._getCards(i);
        }
      }),
    );
    return this._dataStream;
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this._subscription.unsubscribe();
  }

  private _getPageForIndex(index: number): number {
    return Math.floor(index / this._pageSize);
  }

  private _getCards(page: number): void {
    console.log('this', this);
    if (this._fetchedPages.has(page)) {
      return;
    }
    this._fetchedPages.add(page);

    this.searchService.getCards(page, this._pageSize, null)
      .pipe(
        catchError(() => of([]))
      )
      .subscribe((data) => {
        console.log('loading data...', data);
        this._cachedData.splice(
          page * this._pageSize,
          this._pageSize,
          ...data.data,
        );
        // this._cachedData.push(...data.data);
        this._dataStream.next(this._cachedData);
    })
  }

}
