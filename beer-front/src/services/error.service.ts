import { Injectable } from '@angular/core';

@Injectable()
export class ErrorService {

  private messages = [];

  public addMessage(message: string) {
    this.messages.push(message);
  }

  count(): number {
    return this.messages.length;
  }

  getMessages() {
    return this.messages;
  }
  
  clear() {
    this.messages = [];
  }

}
