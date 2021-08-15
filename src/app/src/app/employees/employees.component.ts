import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
// import { Http, Response, Headers, RequestOptions } from '@angular/http';
// import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent {

  managers = ["Denna Livingston", "Lloyd Hanson", "Lacee Marcus"]
  departments = ["Engineering", "Operations"]


  employeeprofileForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    code: new FormControl(''),
    manager: new FormControl(''),
    department: new FormControl(''),
  });

  // constructor(private _http: Http) { }

  // get(url: string): Observable < any > {
  //     return this._http.get(url)
  //              .map((response: Response) => <any>response.json()); 
  // }

  // post(url: string, model: any): Observable <any> {
  //     let formData: FormData = new FormData(); 
  //     formData.append('id', model.id); 
  //     formData.append('applicationName', model.applicationName); 
  //     return this._http.post(url, formData)
  //         .map((response: Response) => {
  //             return response;
  //         }).catch(console.log("error")); 
  // }

  onSubmit() {
    // all the form values
    console.log(this.employeeprofileForm.value)

    // value of the firstName
    console.log(this.employeeprofileForm.controls['firstName'].value)

  }

}
