import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DetailsVoitureComponent } from './voiture/details-voiture/details-voiture.component';
import { ListVoitureComponent } from './voiture/list-voiture/list-voiture.component';

const routes: Routes = [
  { path: '', component: ListVoitureComponent },
  { path: 'login', component: LoginComponent },
  { path: 'voiture/:id', component: DetailsVoitureComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
