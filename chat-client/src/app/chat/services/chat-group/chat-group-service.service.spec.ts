import { TestBed } from '@angular/core/testing';

import { ChatGroupServiceService } from './chat-group-service.service';

describe('ChatGroupServiceService', () => {
  let service: ChatGroupServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChatGroupServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
