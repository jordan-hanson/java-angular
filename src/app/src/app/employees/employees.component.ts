import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent {

  managers = ["Denna Livingston", "Lloyd Hanson", "Lacee Marcus"]
  departments = ["Engineering", "Operations"]

  constructor(private _employeeService: EmployeeService) { }

  employeeprofileForm = new FormGroup({
    firstname: new FormControl(''),
    lastname: new FormControl(''),
    code: new FormControl(''),
  });

  userModel = new User(
    this.employeeprofileForm.controls['firstname'].value,
    this.employeeprofileForm.controls['lastname'].value,
    this.employeeprofileForm.controls['code'].value)

  onSubmit() {
    this.userModel = new User(
      this.employeeprofileForm.controls['firstname'].value,
      this.employeeprofileForm.controls['lastname'].value,
      this.employeeprofileForm.controls['code'].value)

    console.log(this.userModel)
    this._employeeService.add(this.userModel).subscribe(
      data => console.log("success", data),
      error => console.log("error", error)
    )
  }
}
