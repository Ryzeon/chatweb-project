import {Injectable} from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {

  constructor(private router: Router) {
  }

  canActivate(): boolean {
    const access = true;
    if (!access) {
      this.router.navigate(['/login']);
      return false;
    }
    return true;
  }
}
