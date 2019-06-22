import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BeerFilter } from 'src/app/list-beer/list-beer.component';
import { DateService } from './date.service';

@Injectable()
export class BeerService {

  constructor(private httpClient: HttpClient,
    private dateService: DateService) { }

  criaUrlBuscaContrato(beerFilter: BeerFilter) {

    let url = "";

    if (beerFilter != null) {

      if (beerFilter.name) {
        url += '&' + 'name=' + beerFilter.name;
      }

      if (beerFilter.food) {
        url += '&' + 'food=' + beerFilter.food;
      }

      if (beerFilter.abvGt) {
        url += '&' + 'abvGt=' + beerFilter.abvGt;
      }

      if (beerFilter.abvLt) {
        url += '&' + 'abvLt=' + beerFilter.abvLt;
      }
      if (beerFilter.ibuGt) {
        url += '&' + 'ibuGt=' + beerFilter.ibuGt;
      }
      if (beerFilter.ibuLt) {
        url += '&' + 'ibuLt=' + beerFilter.ibuLt;
      }
      if (beerFilter.ebcGt) {
        url += '&' + 'ebcGt=' + beerFilter.ebcGt;
      }
      if (beerFilter.ebcLt) {
        url += '&' + 'ebcLt=' + beerFilter.ebcLt;
      }
      if (beerFilter.yeast) {
        url += '&' + 'yeast=' + beerFilter.yeast;
      }
      if (beerFilter.brewedBefore) {
        // let data = this.dateService.getDateAtualConvertido(beerFilter.brewedBefore);
        url += '&' + 'brewedBefore=' + beerFilter.brewedBefore
      }
      if (beerFilter.brewedAfter) {
        url += '&' + 'brewedAfter=' + beerFilter.brewedAfter;
      }
      if (beerFilter.hops) {
        url += '&' + 'hops=' + beerFilter.hops;
      }
      if (beerFilter.malt) {
        url += '&' + 'malt=' + beerFilter.malt;
      }
      if (beerFilter.ids) {
        url += '&' + 'ids=' + beerFilter.ids;
      }

      return url;
    }
  }

  public searchBeers(page: number, size: number, beerFilter: BeerFilter) {
    return this.httpClient.get(`http://localhost:8080/beer?page=${page}&size=${size}${this.criaUrlBuscaContrato(beerFilter)}`);
  }

}
