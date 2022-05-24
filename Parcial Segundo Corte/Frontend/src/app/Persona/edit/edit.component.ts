import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder  } from '@angular/forms'; 
import { PersonaService } from '../../Service/persona.service'
import { Persona } from 'src/app/Model/Persona';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  formGroup: FormGroup

  persona: Persona = new Persona();
  constructor(
    public form:FormBuilder, 
    private router: Router,
    private service: PersonaService) { 

      this.formGroup = this.form.group({
        id:[''],
        nombres:[''],
        apellidos:[''],
        programa:['']
      })

    }

  ngOnInit(): void {
    this.getInfo();
  }

  getInfo(){
    let id= localStorage.getItem('id');
    if(id != null){
      this.service.findPersonById(+id).subscribe(
        data=>{
          console.log(data);
          this.persona=data;
      });
    }
  }

  update(persona:Persona){
    this.service.updatedPerson(persona).subscribe
    (data=>{
      this.persona=data;
      alert("Updated person...");
      this.router.navigate(["list"]);
    });

  }

}
