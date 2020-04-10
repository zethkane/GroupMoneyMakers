import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { AccountService } from "../account.service";
import { Account} from "../account.model";
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-account',
  templateUrl: './list-account.component.html',
  styleUrls: ['./list-account.component.css']
})
export class ListAccountComponent implements OnInit {

  accounts: Observable<Account[]>;

  constructor(
    private accountService: AccountService,
    private router: Router
  ) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.accounts = this.accountService.getAccountsList();
  }

  deleteAccount(accountId: number){
    this.accountService.deleteAccount(accountId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  accountDetails(accountId: number){
    this.router.navigate(['details', accountId]);
  }

}
