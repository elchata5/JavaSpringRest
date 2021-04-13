package net.guides.springboot2.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.guides.springboot2.crud.model.Inmueble;
import net.guides.springboot2.crud.model.Persona;
import net.guides.springboot2.crud.repository.InmuebleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/test")
public class InmuebleController {
	

	@Autowired
	private InmuebleRepository inmuebleRepository;
	
	@GetMapping("/inmuebles")
	public List<Inmueble> getAllInmuebles() {
		return inmuebleRepository.findAll();
	}

	@GetMapping("/inmuebles/{id}")
	public List<Inmueble> inmueblesInmobiliaria(@PathVariable Long id) {
	        return inmuebleRepository.getInmueblesByInmob(id);
	    }
	
    @GetMapping("/inmueble/{id}")
    Inmueble userById(@PathVariable Long id) {
        return inmuebleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND));
    }

    @PostMapping("/inmueble/save")
    Inmueble save(@RequestBody Inmueble user) {
        return inmuebleRepository.save(user);
    }

}
