package dev.miguel.backend.service;

import dev.miguel.backend.model.Persona;
import dev.miguel.backend.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaService {

    private PersonaRepository personaRepository;

    public List<Persona> list(){
        return personaRepository.findAll();
    }

    public Persona getPersonById(int id){
        return personaRepository.findById(id).get();
    }

    public void save(Persona persona){
        personaRepository.save(persona);
    }

    public void update(Persona personaRequest){
        Persona persona = personaRepository.getReferenceById(personaRequest.getId());
        persona.setNombres(personaRequest.getNombres());
        persona.setApellidos(personaRequest.getApellidos());
        persona.setPrograma(personaRequest.getPrograma());
        personaRepository.save(persona);
    }

    public void delete(int id){
        personaRepository.deleteById(id);
    }

}
