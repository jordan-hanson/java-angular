import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EmployeesComponent } from './employees/employees.component';
import { ManageComponent } from './manage/manage.component';
import { ReportsComponent } from './reports/reports.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: 'employees', component: EmployeesComponent },
  { path: 'manage', component: ManageComponent },
  { path: 'reports', component: ReportsComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
