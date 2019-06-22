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