import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatSidebarContentComponent } from './chat-sidebar-content.component';

describe('ChatSidebarContentComponent', () => {
  let component: ChatSidebarContentComponent;
  let fixture: ComponentFixture<ChatSidebarContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ChatSidebarContentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChatSidebarContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
