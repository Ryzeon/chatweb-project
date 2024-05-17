import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-toolbar-content',
  templateUrl: './toolbar-content.component.html',
  styleUrl: './toolbar-content.component.css'
})
export class ToolbarContentComponent {

  logout() {

  }

  sidebarVisible() {
    document.dispatchEvent(new Event('click-sidebar'));
  }
}
