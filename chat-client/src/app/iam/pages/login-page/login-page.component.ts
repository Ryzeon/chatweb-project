import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MessageService} from "primeng/api";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent implements OnInit{

  loginForm: FormGroup;

  constructor(private router: Router, private messageService: MessageService) {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.minLength(4)]),
      description: new FormControl('', [])
    });
  }

  get name() {
    return this.loginForm.get('username');
  }

  get description() {
    return this.loginForm.get('description');
  }

  login() {
    if (this.loginForm.valid) {
      // this.router.navigate(['/home']);
      console.log('Login success');
    } else {
      this.messageService.add({severity:'error', summary: 'Error', detail: 'Username with at least 4 characters is required.'});
    }
  }

  ngOnInit(): void {
  }
}
