import { Component, OnInit } from '@angular/core';
import { BeerFilter } from 'src/app/model/beer-filter-model';
import { BeerService } from 'src/services/beer.service';

@Component({
  selector: 'app-list-beer',
  templateUrl: './list-beer.component.html',
  styleUrls: ['./list-beer.component.scss']
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
      this.beers = data;
      console.log(data);
      
    });
  }

  public search() {
    this.beerFilter = new BeerFilter();
    this.beerFilter[this.type] = this.searchField;
    this.beerService.searchBeers(this.page, this.size, this.beerFilter).subscribe((data) => {
      // console.log(JSON.stringify(data));
      this.beers = data;
    });
  }

}
