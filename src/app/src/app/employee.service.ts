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
    console.log(user, 'user in post')
    return this._http.post<any>(this._url, user);
  }
}
