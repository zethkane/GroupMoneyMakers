import { Component, OnInit } from '@angular/core';
import { Account} from "../account.model";
import { AccountService } from "../account.service";
import { ListAccountComponent } from "../list-account/list-account.component";
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-account',
  templateUrl: './details-account.component.html',
  styleUrls: ['./details-account.component.css']
})
export class DetailsAccountComponent implements OnInit {

  accountId: number;
  account: Account;

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

  list(){
    this.router.navigate(['accounts']);
  }

}
