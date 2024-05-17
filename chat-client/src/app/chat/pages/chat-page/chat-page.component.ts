import { Component } from '@angular/core';
import {ChatGroup} from "../../model/ChatGroup";

@Component({
  selector: 'app-chat-page',
  templateUrl: './chat-page.component.html',
  styleUrl: './chat-page.component.css'
})
export class ChatPageComponent {

  chatGroup: ChatGroup;

  constructor() {
    this.chatGroup = {} as ChatGroup;
  }

  onChatGroupSelected(chatGroup: ChatGroup): void {
    this.chatGroup = chatGroup;
  }
}
