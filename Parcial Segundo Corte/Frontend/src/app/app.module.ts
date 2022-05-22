import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EditComponent } from './Persona/edit/edit.component';
import { SaveComponent } from './Persona/save/save.component';
import { ListComponent } from './Persona/list/list.component';
import { PersonaService } from './Service/persona.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    EditComponent,
    SaveComponent,
    ListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule 
  ],
  providers: [PersonaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
