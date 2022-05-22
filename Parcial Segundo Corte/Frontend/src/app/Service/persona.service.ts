import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from '../Model/Persona'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  constructor( private http:HttpClient ) { }

  API:string = "http://localhost:8080/personas"

  getPeople(){
    return this.http.get<Persona[]>(this.API);
  }

  savePerson(persona:Persona):Observable<any>{
    return this.http.post<Persona>(this.API, persona);
  }

  findPersonById(id:number){
    return this.http.get<Persona>(`${this.API}/${id}`);
  }

  updatedPerson(persona:Persona){
    return this.http.put<Persona>(`${this.API}`, persona);
  }

  delete(persona:Persona){
    return this.http.delete<Persona>(`${this.API}/${persona.id}`)
  }

}
