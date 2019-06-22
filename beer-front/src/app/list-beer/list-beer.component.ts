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
  brewedBefore: string;
  brewedAfter: string;
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

  public beerFilter: BeerFilter;
  private page = 1;
  private size = 5;
  public beers: any = [];
  public searchField: any;
  public type: any;


  constructor(private beerService: BeerService) { }

  public ngOnInit() {
    this.beerService.searchBeers(this.page, this.size, this.beerFilter).subscribe((data) => {
      // console.log(JSON.stringify(data));
      this.beers = data;
    });
  }

  public search(){
    this.beerFilter = new BeerFilter();
    this.beerFilter[this.type] = this.searchField;
    this.beerService.searchBeers(this.page, this.size, this.beerFilter).subscribe((data) => {
      // console.log(JSON.stringify(data));
      this.beers = data;
    });
  }

}
