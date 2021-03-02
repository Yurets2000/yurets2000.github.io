import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ErrorHandlerService} from './error-handler.service';
import {LoggingService} from './logging.service';
import {Observable} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {ProductCategory} from '../models/ProductCategory';
import {apiUrls} from '../../api-urls';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private readonly basicUrl;

  constructor(
    private http: HttpClient,
    private errorHandlerService: ErrorHandlerService,
    private loggingService: LoggingService) {
    this.basicUrl = apiUrls.API_PRODUCT_CATEGORIES;
  }

  public getAll(): Observable<ProductCategory[]> {
    return this.http.get<ProductCategory[]>(this.basicUrl)
      .pipe(
        tap(_ => this.loggingService.log('fetched product categories')),
        catchError(this.errorHandlerService.handleError<ProductCategory[]>('getAll', []))
      );
  }

  public getById(id: string): Observable<ProductCategory> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.get<ProductCategory>(url).pipe(
      tap(_ => this.loggingService.log(`fetched product category with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<ProductCategory>(`getById, id = ${id}`))
    );
  }

  public getDefault(): Observable<ProductCategory> {
    const url = `${this.basicUrl}/default`;
    return this.http.get<ProductCategory>(url).pipe(
      tap(_ => this.loggingService.log('fetched default product category')),
      catchError(this.errorHandlerService.handleError<ProductCategory>('getDefault'))
    );
  }

  public create(productCategory: ProductCategory): Observable<ProductCategory> {
    return this.http.post<ProductCategory>(this.basicUrl, productCategory, this.httpOptions).pipe(
      tap(_ => this.loggingService.log('created product category')),
      catchError(this.errorHandlerService.handleError<ProductCategory>('create'))
    );
  }

  public update(productCategory: ProductCategory): Observable<ProductCategory> {
    return this.http.put<ProductCategory>(this.basicUrl, productCategory, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`updated product category with id = ${productCategory.id}`)),
      catchError(this.errorHandlerService.handleError<ProductCategory>(`update, id = ${productCategory.id}`))
    );
  }

  public delete(id: string): Observable<any> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.delete<any>(url, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`deleted product category with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<any>(`delete, id = ${id}`))
    );
  }
}
