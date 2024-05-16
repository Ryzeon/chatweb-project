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

  username: string;
  description: string;
  loginForm: FormGroup;

  constructor(private router: Router, private messageService: MessageService) {
    this.username = '';
    this.description = '';
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
    });
  }

  login() {
    if (this.loginForm.valid) {
      // this.router.navigate(['/home']);
      console.log('Login success');
    } else {
      this.messageService.add({severity:'error', summary: 'Error', detail: 'Username is required'});
    }
  }

  ngOnInit(): void {
  }
}
