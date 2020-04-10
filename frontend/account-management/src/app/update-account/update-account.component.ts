import { Component, OnInit } from '@angular/core';
import { Account} from "../account.model";
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService} from "../account.service";

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {

  accountId: number;
  account: Account;
  submitted = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private accountService: AccountService
  ) { }

  ngOnInit() {
    this.account = new Account();
    this.accountId = this.route.snapshot.params['accountId'];
    this.accountService.getAccount(this.accountId)
      .subscribe(data => {
        console.log(data)
        this.account = data;
      }, error => console.log(error));
  }

  updateAccount(){
    this.accountService.updateAccount(this.accountId, this.account)
      .subscribe(data => console.log(data), error => console.log(error));
    this.account = new Account();
    this.gotoList();
  }

  onSubmit(){
    this.submitted = true;
    this.updateAccount();
  }

  gotoList() {
    this.router.navigate(['/accounts']);
  }

}
