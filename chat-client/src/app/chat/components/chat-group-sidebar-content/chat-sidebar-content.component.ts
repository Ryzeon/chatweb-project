import {Component, EventEmitter, Input, Output} from '@angular/core';
import {ChatGroup} from "../../model/ChatGroup";
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {ChatGroupCreatedDialogComponent} from "../chat-group-created-dialog/chat-group-created-dialog.component";

@Component({
  selector: 'app-chat-group-sidebar-content',
  templateUrl: './chat-sidebar-content.component.html',
  styleUrl: './chat-sidebar-content.component.css'
})
export class ChatSidebarContentComponent {

  sidebarVisible: boolean = false;

  @Output() chatGroupSelected: EventEmitter<ChatGroup> = new EventEmitter<ChatGroup>();

  ref: DynamicDialogRef | undefined;

  constructor(private dialogService: DialogService) {
    document.addEventListener('click-sidebar', () => {
      this.onSidebarToggle();
    });
  }

  onSidebarToggle(): void {
    this.sidebarVisible = !this.sidebarVisible;
  }

  selectChatGroup(chatGroup: ChatGroup): void {
    this.chatGroupSelected.emit(chatGroup);
    this.sidebarVisible = false;
  }

  onCreatedChatGroup() {
    this.ref = this.dialogService.open(ChatGroupCreatedDialogComponent, {
      header: 'Create Chat Group',
      width: '20%',
      contentStyle: {"max-height": "350px", "overflow": "auto"}
    });

    this.ref.onClose.subscribe((chatGroup: ChatGroup) => {
      console.log('Chat group created', chatGroup);
    });
  }
}
