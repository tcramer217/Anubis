import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {BehaviorSubject, Observable, of, Subscription} from "rxjs";
import {PokemonSearchService} from "../service/pokemon-search.service";
import {catchError, finalize} from "rxjs/operators";
import {FormGroup} from "@angular/forms";


export default class PokemonDataSource extends DataSource<any> {

  private _length = 102;
  private _pageSize = 10;
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
          this._getCards(i, this._pageSize, null);
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

  private _getCards(page: number, pageSize: number, form: FormGroup | null): void {
    if (form !== null) {
      this._fetchedPages.clear();
      this._cachedData = new Array(this._length);
      this._dataStream.next(this._cachedData);
      this._applyCards(page, pageSize, form);
    }
    if (this._fetchedPages.has(page)) {
      console.log('this', this);
      return;
    }
    this._fetchedPages.add(page);

    this._applyCards(page, pageSize, form);
  }

  private _applyCards(page:number, pageSize:number, form: FormGroup | null): void {
    this.searchService.getCards(page, pageSize, form)
      .pipe(
        catchError(() => of([]))
      )
      .subscribe((data) => {
        console.log('responseData:', data);
        console.log('page:', page);
        this._cachedData.splice(
          page * this._pageSize,
          this._pageSize,
          ...data.data,
        );
        console.log('cachedData:', this._cachedData);
        this._dataStream.next(this._cachedData);
      });
  }

  public getCards(page:number, pageSize:number, form: FormGroup | null): void {
    this._getCards(page, pageSize, form);
  }

}
