import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonaService } from '../../Service/persona.service';
import { Persona } from '../../Model/Persona';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  personas:Persona[] = [];
  constructor( private service:PersonaService, private router:Router ) { }

  ngOnInit(): void {

    this.service.getPeople().subscribe(data => {
      this.personas=data;
      console.log(data);
    })

  }

  update(persona:Persona){
    localStorage.setItem("id", persona.id.toString());
    this.router.navigate(["edit"]);
  }

  delete(persona:Persona){
    this.service.delete(persona).subscribe(
      data => {
        alert("Delete person...");
        this.personas = this.personas.filter(p => p!==persona);
      });
  }
}
