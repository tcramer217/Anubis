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
  private readonly _form;
  private readonly _dataStream = new BehaviorSubject<(string | undefined)[]>(this._cachedData);
  private readonly _subscription = new Subscription();

  constructor(private formGroup: FormGroup, private searchService: PokemonSearchService) {
    super();
    this._form = formGroup;
  }

  connect(collectionViewer: CollectionViewer): Observable<any> {
    this._subscription.add(
      collectionViewer.viewChange.subscribe(range => {
        const startPage = this._getPageForIndex(range.start);
        const endPage = this._getPageForIndex(range.end - 1);
        for (let i = startPage; i <= endPage; i++) {
          this._getCards(i, this._pageSize, this._form);
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

    if (this._fetchedPages.has(page)) {
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
        this._cachedData.splice(
          page * this._pageSize,
          this._pageSize,
          ...data.data,
        );
        this._dataStream.next(this._cachedData);
      });
  }

  public getCards(page:number, pageSize:number, form: FormGroup | null, isSearch?: boolean): void {
    if(isSearch) {
        this._fetchedPages.clear();
        this._cachedData = new Array(this._length);
        this._dataStream.next(this._cachedData);
    }
    this._getCards(page, pageSize, form);
  }

}
