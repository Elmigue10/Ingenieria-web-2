import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonaService } from 'src/app/Service/persona.service';
import { FormGroup, FormBuilder  } from '@angular/forms'; 

@Component({
  selector: 'app-save',
  templateUrl: './save.component.html',
  styleUrls: ['./save.component.css']
})
export class SaveComponent implements OnInit {

  formGroup: FormGroup

  constructor( 
    public form:FormBuilder, 
    private router: Router, 
    private service:PersonaService) {

    this.formGroup = this.form.group({
      nombres:[''],
      apellidos:[''],
      programa:['']
    })

  }

  ngOnInit(): void {
  }

  save():any{
    console.log(this.formGroup.value)
    this.service.savePerson(this.formGroup.value).subscribe(
      data => {
        alert("Saved person...")
        this.router.navigate(["list"])
      }
    );
  }

}
