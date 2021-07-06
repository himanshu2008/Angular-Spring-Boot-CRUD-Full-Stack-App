import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  firstName!: string;
  lastName!: string;
  emailId!: string;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }

  goToViewEmployee() {
    this.router.navigate(['/']);
  }

  onSubmit() {
    console.log("Hi");
    console.log(this.firstName);
        console.log(this.lastName);
        console.log(this.emailId);
    this.employeeService.addEmployee(this.firstName, this.lastName, this.emailId).subscribe(employee => {
      // if (this.firstName == "" || this.lastName == null || this.emailId == null) {
        console.log(this.firstName);
        console.log(this.lastName);
        console.log(this.emailId);
      // }
      // else
        this.goToViewEmployee();
    },
      error => {
        console.log(error)
      });
  }

}
