import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import { AssociadoComponent } from './associado/associado.component';
import { VoteComponent } from './vote/vote.component';
import { HomeComponent } from './home/home.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { SessionVoteComponent } from './session-vote/session-vote.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: "associado", component: AssociadoComponent},
    {path: "schedule", component: ScheduleComponent},
    {path: "vote", component: VoteComponent},
    {path: "session-vote", component: SessionVoteComponent}
];
