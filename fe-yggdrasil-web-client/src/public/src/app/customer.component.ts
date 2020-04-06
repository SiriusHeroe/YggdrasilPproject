import { Component } from '@angular/core';
import {AppService, Customer} from './app.service'

@Component({
  selector: 'customer-details',
  providers: [AppService],
  template: `<div class="container">
    <h1 class="col-sm-12">Customer Details</h1>
    <div class="col-sm-12">
        <label class="col-sm-3">ID</label> <span>{{customer.id}}</span>
    </div>
    <div class="col-sm-12">
        <label class="col-sm-3">Name</label> <span>{{customer.name}}</span>
    </div>
    <div class="col-sm-12">
        <button class="btn btn-primary" (click)="getCustomer()" type="submit">Get customer</button>
    </div>
</div>`
})

export class CustomerComponent {
    public customer = new Customer("f9ea598b-d530-4312-97cb-37a4532f1c2e",'sample customer');
    private customerApiV1 = 'http://localhost:2705/resource-server/customer/api/v1/customers/';

    constructor(private _service:AppService) {}

    getCustomer(){
        this._service.getResource(this.customerApiV1+this.customer.id)
         .subscribe(
                     data => this.customer = data,
                     error =>  this.customer.name = 'Error');
    }
}
