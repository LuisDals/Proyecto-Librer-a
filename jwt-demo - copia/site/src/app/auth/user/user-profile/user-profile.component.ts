import { Component } from '@angular/core';
import { Users } from '../../model/user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent {
  hasToken: boolean = false;
  username: string = '';
  isAuthenticated = false;
  user?: Users; 

  constructor(private router: Router, private authService: AuthService, private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['username']; 
    console.log(this.username);// Obtén el username del snapshot
    this.loadUserProfile();
  }

  loadUserProfile() {
    const token = this.authService.getToken();
    if (token) {
      this.isAuthenticated = true;
      this.http.get<any>(`http://localhost:8080/api/v1/user/${this.username}`, {
        headers: { Authorization: `Bearer ${token}` }
      }).subscribe({
        next: (data) => {
          console.log("Datos de usuario", data);
          this.user = data;
        },
        error: (error) => {
          console.error('Error getting user', error);
        }
      });
    }
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  Token(): boolean {
    return this.authService.getToken() ? true : false;
  }

  deleteAccount() {
    // Lógica para borrar la cuenta
  }

}
