import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {LoggingService} from './logging.service';
import {Observable} from 'rxjs';
import {Product} from '../models/Product';
import {catchError, tap} from 'rxjs/operators';
import {ErrorHandlerService} from './error-handler.service';
import {apiUrls} from '../../api-urls';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private readonly basicUrl;

  constructor(
    private http: HttpClient,
    private errorHandlerService: ErrorHandlerService,
    private loggingService: LoggingService) {
    this.basicUrl = apiUrls.API_PRODUCTS;
  }

  public getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.basicUrl)
      .pipe(
        tap(_ => this.loggingService.log('fetched products')),
        catchError(this.errorHandlerService.handleError<Product[]>('getAll', []))
      );
  }

  public getById(id: string): Observable<Product> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.get<Product>(url).pipe(
      tap(_ => this.loggingService.log(`fetched product with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<Product>(`getById, id = ${id}`))
    );
  }

  public create(productCategoryId: string, product: Product): Observable<Product> {
    const url = `${this.basicUrl}/${productCategoryId}`;
    return this.http.post<Product>(url, product, this.httpOptions).pipe(
      tap(_ => this.loggingService.log('created product')),
      catchError(this.errorHandlerService.handleError<Product>('create'))
    );
  }

  public update(product: Product): Observable<Product> {
    return this.http.put<Product>(this.basicUrl, product, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`updated product with id = ${product.id}`)),
      catchError(this.errorHandlerService.handleError<Product>(`update, id = ${product.id}`))
    );
  }

  public delete(id: string): Observable<any> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.delete<any>(url, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`deleted product with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<any>(`delete, id = ${id}`))
    );
  }
}
