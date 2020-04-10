import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAccountComponent } from "./create-account/create-account.component";
import { DetailsAccountComponent } from "./details-account/details-account.component";
import { ListAccountComponent } from "./list-account/list-account.component";
import { UpdateAccountComponent } from "./update-account/update-account.component";
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    CreateAccountComponent,
    DetailsAccountComponent,
    ListAccountComponent,
    UpdateAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
