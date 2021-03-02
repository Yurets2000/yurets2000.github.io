import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ErrorHandlerService} from './error-handler.service';
import {LoggingService} from './logging.service';
import {Offering} from '../models/Offering';
import {apiUrls} from '../../api-urls';

@Injectable({
  providedIn: 'root'
})
export class OfferingService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private readonly basicUrl;

  constructor(private http: HttpClient,
              private errorHandlerService: ErrorHandlerService,
              private loggingService: LoggingService) {
    this.basicUrl = apiUrls.API_OFFERINGS;
  }

  public getAll(): Observable<Offering[]> {
    return this.http.get<Offering[]>(this.basicUrl)
      .pipe(
        tap(_ => this.loggingService.log('fetched offerings')),
        catchError(this.errorHandlerService.handleError<Offering[]>('getAll', []))
      );
  }

  public getById(id: string): Observable<Offering> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.get<Offering>(url).pipe(
      tap(_ => this.loggingService.log(`fetched offering with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<Offering>(`getById, id = ${id}`))
    );
  }

  public getDefault(): Observable<Offering> {
    const url = `${this.basicUrl}/default`;
    return this.http.get<Offering>(url).pipe(
      tap(_ => this.loggingService.log('fetched default offering')),
      catchError(this.errorHandlerService.handleError<Offering>('getDefault'))
    );
  }

  public create(offering: Offering): Observable<Offering> {
    return this.http.post<Offering>(this.basicUrl, offering, this.httpOptions).pipe(
      tap(_ => this.loggingService.log('created offering')),
      catchError(this.errorHandlerService.handleError<Offering>('create'))
    );
  }

  public update(offering: Offering): Observable<Offering> {
    return this.http.put<Offering>(this.basicUrl, offering, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`updated offering with id = ${offering.id}`)),
      catchError(this.errorHandlerService.handleError<Offering>(`update, id = ${offering.id}`))
    );
  }

  public delete(id: string): Observable<any> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.delete<any>(url, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`deleted offering with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<any>(`delete, id = ${id}`))
    );
  }
}
