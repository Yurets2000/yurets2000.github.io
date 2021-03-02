import {Injectable} from '@angular/core';
import {LoggingService} from './logging.service';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService {

  constructor(private loggingService: LoggingService) {
  }

  public handleError<T>(operation = 'operation', result?: T): any {
    return (error: any): Observable<T> => {
      console.error(error);
      this.loggingService.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
