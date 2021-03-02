import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ErrorHandlerService} from './error-handler.service';
import {LoggingService} from './logging.service';
import {Observable} from 'rxjs';
import {Product} from '../models/Product';
import {catchError, tap} from 'rxjs/operators';
import {ProductComment} from '../models/ProductComment';
import {apiUrls} from '../../api-urls';

@Injectable({
  providedIn: 'root'
})
export class ProductCommentService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private readonly basicUrl;

  constructor(
    private http: HttpClient,
    private errorHandlerService: ErrorHandlerService,
    private loggingService: LoggingService) {
    this.basicUrl = apiUrls.API_PRODUCT_COMMENTS;
  }

  public getAll(): Observable<ProductComment[]> {
    return this.http.get<ProductComment[]>(this.basicUrl)
      .pipe(
        tap(_ => this.loggingService.log('fetched product comments')),
        catchError(this.errorHandlerService.handleError<ProductComment[]>('getAll', []))
      );
  }

  public getById(id: string): Observable<ProductComment> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.get<ProductComment>(url).pipe(
      tap(_ => this.loggingService.log(`fetched product comment with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<ProductComment>(`getById, id = ${id}`))
    );
  }

  public create(productId: string, productComment: ProductComment): Observable<ProductComment> {
    const url = `${this.basicUrl}/${productId}`;
    return this.http.post<ProductComment>(url, productComment, this.httpOptions).pipe(
      tap(_ => this.loggingService.log('created product comment')),
      catchError(this.errorHandlerService.handleError<ProductComment>('create'))
    );
  }

  public update(productComment: ProductComment): Observable<Product> {
    return this.http.put<ProductComment>(this.basicUrl, productComment, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`updated product with id = ${productComment.id}`)),
      catchError(this.errorHandlerService.handleError<ProductComment>(`update, id = ${productComment.id}`))
    );
  }

  public delete(id: string): Observable<any> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.delete<any>(url, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`deleted product comment with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<any>(`delete, id = ${id}`))
    );
  }
}
