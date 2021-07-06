import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewEmployeeComponent } from './component/view-employee/view-employee.component';
import { AddEmployeeComponent } from './component/add-employee/add-employee.component';
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  { path: 'employee', component: ViewEmployeeComponent },
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'addEmployee', component: AddEmployeeComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    ViewEmployeeComponent,
    AddEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes, { enableTracing: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
