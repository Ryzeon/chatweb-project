import {Component} from '@angular/core';
import {DynamicDialogRef} from "primeng/dynamicdialog";
import {ChatGroup} from "../../model/ChatGroup";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MessageService} from "primeng/api";

@Component({
  selector: 'app-chat-group-created-dialog',
  templateUrl: './chat-group-created-dialog.component.html',
  styleUrl: './chat-group-created-dialog.component.css'
})
export class ChatGroupCreatedDialogComponent {

  groupForm: FormGroup;

  constructor(private dialogRef: DynamicDialogRef, private message: MessageService) {
    this.groupForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3)])
    });
  }

  getGroupName(): string {
    return this.groupForm.get('name')?.value;
  }

  createChatGroup(): void {
    if (this.groupForm.invalid) {
      this.message.add({severity: 'error', summary: 'Error', detail: 'Please provide a chat group name'});
      return;
    }
    this.closeDialog({id: 2, name: this.getGroupName()} as ChatGroup);
  }

  closeDialog(chatGroup: ChatGroup) {
    this.dialogRef.close(chatGroup);
  }
}
