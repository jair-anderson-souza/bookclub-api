import { Injectable } from '@angular/core';

@Injectable()
export class DateService {

  public getDateAtualConvertido(data: Date): string {

    function pad(n) {
      return n < 10 ? '0' + n : n;
    }

    return pad(data.getUTCMonth() + 1) + '-'
      + pad(data.getUTCFullYear());
    // + ' '
  }
}