import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionVoteComponent } from './session-vote.component';

describe('SessionVoteComponent', () => {
  let component: SessionVoteComponent;
  let fixture: ComponentFixture<SessionVoteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SessionVoteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SessionVoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
