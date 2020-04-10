import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private baseUrl = 'http://localhost:8080/accounts';

  constructor(private http: HttpClient) { }

   getAccount(accountId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/${accountId}`);
   }
   createAccount(account: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`, account);
   }
   updateAccount(accountId: number, value: any): Observable<Object>{
     return this.http.put(`${this.baseUrl}/${accountId}`, value);
   }
   deleteAccount(accountId: number): Observable<any>{
     return this.http.delete(`${this.baseUrl}/${accountId}`, { responseType: 'text' });
   }
   getAccountsList(): Observable<any>{
     return this.http.get(`${this.baseUrl}`);
   }
}
