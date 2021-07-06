import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  private url = "http://localhost:3333/ems";

  constructor(private http: HttpClient) { }

  getEmployeeList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.url + "/employees");
  }

  addEmployee(firstName: string, lastName: string, emailId: string): Observable<Employee> {
    return this.http.post<Employee>(this.url + "/addEmployee", { firstName, lastName, emailId }, { headers: this.headers, responseType: 'text' as 'json' });
  }
}
