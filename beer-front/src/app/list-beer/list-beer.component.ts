import { Component, OnInit } from '@angular/core';
import { BeerService } from 'src/services/beer.service';

export class BeerFilter {

  name: string;
  food: string;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }

}

@Component({
  selector: 'app-list-beer',
  templateUrl: './list-beer.component.html',
  styleUrls: ['./list-beer.component.sass']
})

export class ListBeerComponent implements OnInit {
  
  constructor(private beerService: BeerService) {
    this.beerService.searchBeers();
  }

  ngOnInit() {
    
  }

}
