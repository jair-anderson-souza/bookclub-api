import { Component, OnInit } from '@angular/core';
import { BeerService } from 'src/services/beer.service';

export class BeerFilter {

  name: string;
  food: string;
  abvGt: number;
  abvLt: number;
  ibuGt: number;
  ibuLt: number;
  ebcGt: number;
  ebcLt: number;
  yeast: string;
  brewedBefore: Date;
  brewedAfter: Date;
  hops: string;
  malt: string;
  ids: string;

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
  private beerFilter = new BeerFilter({brewedBefore: new Date()});
  private page = 1;
  private size = 5;


  constructor(private beerService: BeerService) { }

  ngOnInit() {
    this.beerService.searchBeers(this.page, this.size, this.beerFilter).subscribe((data) => {
      console.log(JSON.stringify(data));
    });
  }

}
