package net.guides.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Inmobiliaria;
import net.guides.springboot2.crud.model.Persona;
import net.guides.springboot2.crud.repository.PersonaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/test")
public class PersonaController {
	

	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/personas")
	public List<Persona> getAllPersonas() {
		return personaRepository.findAll();
	}
	
	@GetMapping("/personas/{id}")
	public List<Persona> personasInmobiliarias(@PathVariable Long id) {
	        return personaRepository.getPersonasByInmob(id);
	    }
	 
    @GetMapping("/persona/{id}")
    Persona userById(@PathVariable Long id) {
        return personaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND));
    }

    @PostMapping("/persona/save")
    Persona save(@RequestBody Persona user) {
        return personaRepository.save(user);
    }
    
    @DeleteMapping("/persona/delete/{id}")
    public Map<String, Boolean> deletePersona(@PathVariable(value = "id") Long id)
         throws ResourceNotFoundException {
        Persona inmob = personaRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Inmobiliaria not found for this id :: " + id));

        personaRepository.delete(inmob);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
