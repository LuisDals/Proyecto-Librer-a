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
  users: Users[] = [];
  token: string = '';

  constructor(private router: Router, private authService: AuthService, private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['username']; 
    console.log(this.username);
    this.loadUserProfile();
    this.loadUsersProfiles();
  }

  loadUserProfile() {
    this.token = this.authService.getToken()!;
    if (this.token) {
      this.isAuthenticated = true;
      this.http.get<any>(`http://localhost:8080/api/v1/user/${this.username}`, {
        headers: { Authorization: `Bearer ${this.token}` }
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

  loadUsersProfiles() {
    if (this.token) { 
      this.isAuthenticated = true;
      this.http.get<Users[]>(`http://localhost:8080/api/v1/user/all`, {
        headers: { Authorization: `Bearer ${this.token}` }
      }).subscribe({
        next: (data) => {
          console.log("Datos de usuarios", data);
          this.users = data;
        },
        error: (error) => {
          console.error('Error getting users', error);
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
    const token = this.authService.getToken();
    if(token) {
      this.isAuthenticated = true;
      this.http.delete(`http://localhost:8080/api/v1/user/${this.username}`, {
        headers: { Authorization: `Bearer ${token}`}
      }).subscribe({
        next: () => {
          alert("User delete succesfully");
          this.authService.logout();
          this.router.navigate(['/login']);
        }
      })
    }
  }


  confirmDelete(){
    if (window.confirm('Are you sure you want to delete your account?')) {
      this.deleteAccount();
    }
  }
}
