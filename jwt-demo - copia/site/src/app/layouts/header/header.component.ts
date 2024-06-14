import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Users } from 'src/app/auth/model/user.model';
import { AuthService } from 'src/app/auth/service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent implements OnInit{
  hasToken: boolean = false;
  username: string = '';
  isAuthenticated = false;
  user?: Users; 

  constructor(private router: Router, private authService: AuthService, private route: ActivatedRoute, private http: HttpClient) { }
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      let from = params['from'];
      if(from === "login"){
        this.logInAuth();
      } else if (from === "register"){
        this.registeredAuth();
      }
    });
  }

  logInAuth(){
    this.route.queryParamMap.subscribe(params => {
      this.username = params.get('username') ?? '';
      const token = this.authService.getToken();
      if(token){
        this.isAuthenticated = true;
        this.http.get<any>(`http://localhost:8080/api/v1/user/${this.username}`, {
          headers: { Authorization: `Bearer ${token}`}
        }).subscribe({
          next: (data) => {
            console.log("Datos de usuario" , data);
            this.user = data;
          },
          error: (error) => {
            console.error('Error getting user', error);
          }
        });
      }
    });
  }

  registeredAuth(){
    this.route.queryParamMap.subscribe(params => {
      this.username = params.get('username') ?? '';
      const token = this.authService.getToken();
      this.isAuthenticated = true;
      this.http.get<any>(`http://localhost:8080/api/v1/user/${this.username}`, {
          headers: { Authorization: `Bearer ${token}`}
        }).subscribe({
          next: (data) => {
            console.log("Datos de usuario" , data);
            this.user = data;
          },
          error: (error) => {
            console.error('Error getting user', error);
          }
        });
  });
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  Token() : boolean{
    if(this.authService.getToken()) {
      return this.hasToken = true;
    } else {
      return this.hasToken = false;
    }
  }

  goToHomePage(): void {
    this.router.navigate(['/homepage'], { queryParams: { user: this.username } });
  }
}
