import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatGroupCreatedDialogComponent } from './chat-group-created-dialog.component';

describe('ChatGroupCreatedDialogComponent', () => {
  let component: ChatGroupCreatedDialogComponent;
  let fixture: ComponentFixture<ChatGroupCreatedDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ChatGroupCreatedDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChatGroupCreatedDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
