import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReportsService {

  constructor(private _http: HttpClient) { }

  getData() {
    let url = "http://localhost:8080/users/users"
    return this._http.get(url)
  }
}
