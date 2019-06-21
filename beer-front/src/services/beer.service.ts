import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class BeerService {

  constructor(private httpClient: HttpClient) {

  }

  public searchBeers() {
    this.httpClient.get("http://localhost:8080/beer").subscribe((data) => {
      alert(JSON.stringify(data));
    });

  }


}