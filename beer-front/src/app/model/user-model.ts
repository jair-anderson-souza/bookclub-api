export class User {
  name: string;
  username: string;
  password: string;
  roles = [];
  
  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
  
}