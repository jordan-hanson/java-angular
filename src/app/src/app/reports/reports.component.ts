import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ReportsService } from '../reports.service';
import { Department } from '../models/department.model';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})
export class ReportsComponent {
  departments = ["Engineering", "Operations", "Accounting"]
  result = [] as any;
  filtered = [] as any;
  constructor(private _reportsService: ReportsService) { }

  filteredDataForm = new FormGroup({
    department: new FormControl('')
  });

  departmentModel = new Department(
    this.filteredDataForm.controls['department'].value)

  getUsers() {
    this._reportsService.getData().subscribe(data => {
      this.result = data
    }
    )
  }
  getFiltered() {
    this.departmentModel = new Department(
      this.filteredDataForm.controls['department'].value)
    this.filtered.length = 0
    this.result.forEach((element: any) => {
      if (this.departmentModel.department === element.department) {
        this.filtered.push(element)
      }
    });
  }


}
