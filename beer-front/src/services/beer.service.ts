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

      url = "?";

      if (beerFilter.name) {
        url += '&' + 'name=' + beerFilter.name;
      }

      if (beerFilter.food) {
        url += '&' + 'food=' + beerFilter.food;
      }

      if (beerFilter.abvGt) {
        url += '&' + 'abv_gt=' + beerFilter.abvGt;
      }

      if (beerFilter.abvLt) {
        url += '&' + 'abv_lt=' + beerFilter.abvLt;
      }
      if (beerFilter.ibuGt) {
        url += '&' + 'ibu_gt=' + beerFilter.ibuGt;
      }
      if (beerFilter.ibuLt) {
        url += '&' + 'ibu_lt=' + beerFilter.ibuLt;
      }
      if (beerFilter.ebcGt) {
        url += '&' + 'ebc_gt=' + beerFilter.ebcGt;
      }
      if (beerFilter.ebcLt) {
        url += '&' + 'ebc_lt=' + beerFilter.ebcLt;
      }
      if (beerFilter.yeast) {
        url += '&' + 'yeast=' + beerFilter.yeast;
      }
      if (beerFilter.brewedBefore) {
        let data = this.dateService.getDateAtualConvertido(beerFilter.brewedBefore);
        url += '&' + 'brewedBefore=' + data
      }
      if (beerFilter.brewedAfter) {
        url += '&' + 'brewed_after=' + beerFilter.brewedAfter;
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
    return this.httpClient.get(`http://localhost:8080/beer?page=${page}&size=${size}&${this.criaUrlBuscaContrato(beerFilter)}`);
  }

}
