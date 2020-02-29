import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';
import {Device} from '../models/device';
import {MatSnackBar} from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class DeviceApiService {

  // Define API
  apiURL = '/api/v1';
  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  /*========================================
    CRUD Methods for consuming RESTful API
  =========================================*/

  constructor(private http: HttpClient,
              private snackBar: MatSnackBar) {
  }

  getDevices(): Observable<Device[]> {
    return this.http.get<Device[]>(this.apiURL + '/device')
      .pipe(
        retry(1),
        catchError(err => this.handleError(err)),
      );
  }


  getDevice(id): Observable<Device> {
    return this.http.get<Device>(this.apiURL + '/device/' + id)
      .pipe(
        retry(1),
        catchError(err => this.handleError(err)),
      );
  }

  createDevice(device): Observable<Device> {
    return this.http.post<Device>(
      this.apiURL + '/device', JSON.stringify(device), this.httpOptions)
      .pipe(
        retry(1),
        catchError(err => this.handleError(err)),
      );
  }

  updateCleaningSchedule(cleaningSchedule): Observable<Device> {
    return this.http.put<Device>(
      this.apiURL + '/device/' + cleaningSchedule.id, JSON.stringify(cleaningSchedule), this.httpOptions)
      .pipe(
        retry(1),
        catchError(err => this.handleError(err)),
      );
  }

  deleteDevice(id) {
    return this.http.delete<Device>(this.apiURL + '/device/' + id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(err => this.handleError(err)),
      );
  }

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
      this.snackBar.open(`Ein Fehler ist aufgetreten ${error.error.message}`,
        '',
        {
          panelClass: ['bg-warning', 'text-dark']
        });
    } else {
      // Get server-side error
      this.snackBar.open(`Ein Fehler ist aufgetreten (${error.status}): ${error.message}`,
        '',
        {
          panelClass: ['bg-warning', 'text-dark']
        });
    }
    return throwError(errorMessage);
  }


}
