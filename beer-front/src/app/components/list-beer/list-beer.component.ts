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
  public page = 1;
  private size = 50;
  numberMinPages = 1;
  numberMaxPages = 7;
  public beers: any = [];
  public searchField: any;
  public type = '';


  constructor(private beerService: BeerService) { 
  }

  public ngOnInit() {
    this.beerService.searchBeers(this.page, this.size, this.beerFilter).subscribe((data) => {
      this.beers = data;
    });
  }

  public search() {
    this.beerFilter = new BeerFilter();
    this.beerFilter[this.type] = this.searchField;
    this.beerService.searchBeers(this.page, this.size, this.beerFilter).subscribe((data) => {
      this.beers = data;
      console.log(data);
    });
    this.page = 1;
  }

  public changePage(page) {
    this.page = page;
    this.beerService.searchBeers(this.page, this.size, this.beerFilter).subscribe((data) => {
      this.beers = data;
    });
  }

  public backIndex() {
    if (this.page > this.numberMinPages) {
      this.page = this.page - 1;
    }

    this.changePage(this.page);
  }

  public goToPage() {
    if (this.page < this.numberMaxPages) {
      this.page = this.page + 1;
    }
    this.changePage(this.page);
  }
}
