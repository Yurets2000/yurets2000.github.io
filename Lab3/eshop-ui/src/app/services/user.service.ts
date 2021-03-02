import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ErrorHandlerService} from './error-handler.service';
import {LoggingService} from './logging.service';
import {BehaviorSubject, Observable} from 'rxjs';
import {Offering} from '../models/Offering';
import {catchError, tap} from 'rxjs/operators';
import {apiUrls} from '../../api-urls';
import {User} from '../models/User';
import {Router} from '@angular/router';
import {constants} from '../../constants';
import {v4 as uuidv4} from 'uuid';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private readonly basicUrl;

  private userSubject: BehaviorSubject<User>;
  public user: Observable<User>;

  constructor(private router: Router,
              private http: HttpClient,
              private errorHandlerService: ErrorHandlerService,
              private loggingService: LoggingService) {
    this.basicUrl = apiUrls.API_USERS;
    let userStr = localStorage.getItem('user');
    if (!userStr || userStr === 'undefined') {
      userStr = JSON.stringify(constants.DEFAULT_USER);
      this.loginAnonymous();
    } else {
      const userObj = JSON.parse(userStr);
      this.login(userObj.email, userObj.password);
    }
    console.log('userStr: ' + userStr);
    this.userSubject = new BehaviorSubject<User>(JSON.parse(userStr));
    this.user = this.userSubject.asObservable();
  }

  public get userValue(): User {
    return this.userSubject.value;
  }

  public getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.basicUrl)
      .pipe(
        tap(_ => this.loggingService.log('fetched users')),
        catchError(this.errorHandlerService.handleError<Offering[]>('getAll', []))
      );
  }

  public getById(id: string): Observable<User> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.get<User>(url).pipe(
      tap(_ => this.loggingService.log(`fetched user with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<User>(`getById, id = ${id}`))
    );
  }

  public loginAnonymous(): void {
    const anonymousUser = constants.DEFAULT_USER;
    anonymousUser.username = 'Anonymous User';
    anonymousUser.email = uuidv4();
    anonymousUser.password = uuidv4();
    this.create(anonymousUser).subscribe(
      user => {
        console.log('created anonymous user: ' + JSON.stringify(user));
        localStorage.setItem('user', JSON.stringify(user));
        this.userSubject.next(user);
      }
    );
  }

  public login(email: string, password: string): void {
    this.findByEmailAndPassword(email, password).subscribe(
      user => {
        console.log('logged in user: ' + JSON.stringify(user));
        localStorage.setItem('user', JSON.stringify(user[0]));
        this.userSubject.next(user[0]);
      }
    );
  }

  public logout(): void {
    localStorage.removeItem('user');
    this.userSubject.next(null);
    this.router.navigate(['']);
  }

  public findByEmailAndPassword(email: string, password: string): Observable<User> {
    const url = `${this.basicUrl}?email=${email}&password=${password}`;
    return this.http.get<User>(url).pipe(
      tap(_ => this.loggingService.log(`fetched user by email and password with email = ${email}`)),
      catchError(this.errorHandlerService.handleError<User>(`findByEmailAndPassword, email = ${email}`))
    );
  }

  public create(user: User): Observable<User> {
    return this.http.post<Offering>(this.basicUrl, user, this.httpOptions).pipe(
      tap(_ => this.loggingService.log('created user')),
      catchError(this.errorHandlerService.handleError<User>('create'))
    );
  }

  public update(user: User): Observable<User> {
    return this.http.put<User>(this.basicUrl, user, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`updated user with id = ${user.id}`)),
      catchError(this.errorHandlerService.handleError<User>(`update, id = ${user.id}`))
    );
  }

  public delete(id: string): Observable<any> {
    const url = `${this.basicUrl}/${id}`;
    return this.http.delete<any>(url, this.httpOptions).pipe(
      tap(_ => this.loggingService.log(`deleted user with id = ${id}`)),
      catchError(this.errorHandlerService.handleError<any>(`delete, id = ${id}`))
    );
  }
}
