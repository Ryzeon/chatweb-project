import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SocketService {

  stompClient: any

  constructor() { }

  connect(): void {
    let socket = new WebSocket('http://localhost:8080/ws');
  }
}
