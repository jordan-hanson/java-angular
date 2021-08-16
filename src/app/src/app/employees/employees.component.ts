import { Component } from '@angular/core';
import { Router } from '@angular/router';
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
  departments = ["Engineering", "Operations", "Accounting"]
  result = [] as any;


  constructor(private router: Router, private _employeeService: EmployeeService) { }

  employeeprofileForm = new FormGroup({
    firstname: new FormControl(''),
    lastname: new FormControl(''),
    code: new FormControl(''),
    manager: new FormControl(''),
    department: new FormControl('')
  });

  userModel = new User(
    this.employeeprofileForm.controls['firstname'].value,
    this.employeeprofileForm.controls['lastname'].value,
    this.employeeprofileForm.controls['code'].value,
    this.employeeprofileForm.controls['manager'].value,
    this.employeeprofileForm.controls['department'].value)

  goHome() {
    this.router.navigateByUrl('/home')
  }

  onSubmit() {
    this.userModel = new User(
      this.employeeprofileForm.controls['firstname'].value,
      this.employeeprofileForm.controls['lastname'].value,
      this.employeeprofileForm.controls['code'].value,
      this.employeeprofileForm.controls['manager'].value,
      this.employeeprofileForm.controls['department'].value)

    this._employeeService.add(this.userModel).subscribe(
      data => console.log("success", data),
      error => console.log("error", error)
    )
  }

  getUsers() {
    this._employeeService.getData().subscribe(data => {
      this.result = data
    }
    )
  }
}
