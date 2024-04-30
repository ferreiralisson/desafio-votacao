import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-session-vote',
  standalone: true,
  imports: [
    RouterModule,
    MatCardModule
  ],
  templateUrl: './session-vote.component.html',
  styleUrl: './session-vote.component.css'
})
export class SessionVoteComponent {

}
