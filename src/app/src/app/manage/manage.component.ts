import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})
export class ManageComponent implements OnInit {

  constructor(private router: Router, private _employeeService: EmployeeService) { }

  result = [] as any;

  ngOnInit(): void {
  }

  manageClick() {
    this.router.navigateByUrl('/employees')
  }

  goHome() {
    this.router.navigateByUrl('/home')
  }

  departmentClick() {
    this.router.navigateByUrl('/employees')
  }
  getUsers() {
    this._employeeService.getData().subscribe(data => {
      console.log(data, 'response data')
      this.result = data
      console.log(this.result, 'result')
    }
    )
  }
}
