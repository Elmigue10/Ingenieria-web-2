import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditComponent } from './Persona/edit/edit.component';
import { ListComponent } from './Persona/list/list.component';
import { SaveComponent } from './Persona/save/save.component';

const routes: Routes = [
  {path: 'list', component: ListComponent},
  {path: 'save', component: SaveComponent},
  {path: 'edit', component:EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
