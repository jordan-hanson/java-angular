import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../app/models/user.model'

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {


  _url = "http://localhost:8080/users/user";

  constructor(private _http: HttpClient) { }

  add(user: User) {
    return this._http.post<any>(this._url, user);
  }

  getData() {
    let url = "http://localhost:8080/users/users"
    return this._http.get(url)
  }

}
