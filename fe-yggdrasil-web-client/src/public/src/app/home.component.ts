import {Component} from '@angular/core';
import {AppService} from './app.service'

@Component({
    selector: 'home-header',
    providers: [AppService],
  template: `<div class="container" >
    <button *ngIf="!isLoggedIn" class="btn btn-primary" (click)="login()" type="submit">Login</button>
    <div *ngIf="isLoggedIn" class="content">
        <span>Welcome !!</span>
        <a class="btn btn-default pull-right"(click)="logout()" href="#">Logout</a>
        <br/>
        <customer-details></customer-details>
    </div>
</div>`
})

export class HomeComponent {
     public isLoggedIn = false;

    constructor(
        private _service:AppService){}

    ngOnInit(){
        this.isLoggedIn = this._service.checkCredentials();
        let i = window.location.href.indexOf('code');
        if(!this.isLoggedIn && i != -1){
            this._service.retrieveToken(window.location.href.substring(i + 5));
        }
    }

    login() {
        window.location.href = 'http://localhost:2702/auth/realms/yggdrasil/protocol/openid-connect/auth?response_type=code&&scope=write%20read&client_id=' +
          this._service.clientId + '&redirect_uri='+ this._service.redirectUri;
    }

    logout() {
        this._service.logout();
    }
}
