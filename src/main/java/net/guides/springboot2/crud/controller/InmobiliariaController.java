package net.guides.springboot2.crud.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import net.guides.springboot2.crud.model.Pago;
import net.guides.springboot2.crud.model.Login;
import net.guides.springboot2.crud.repository.InmobiliariaRepository;
import net.guides.springboot2.crud.repository.PagoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/test")
public class InmobiliariaController {
	
	@Autowired
	private InmobiliariaRepository inmobiliariaRepository;
	
	
	  @Autowired private PagoRepository pagoRepository;
	 
	
	@GetMapping("/inmobiliarias")
	public List<Inmobiliaria> getAllEmployees() {
		return inmobiliariaRepository.findAll();
	}
	
	
	/*
	 * @GetMapping("/pagos") public List<Pago> getAllPagos() { return
	 * pagoRepository.findAll(); }
	 */

    @GetMapping("/inmobiliaria/{id}")
    Inmobiliaria userById(@PathVariable Long id) {
        return inmobiliariaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND));
    }

    @PostMapping("/inmobiliaria/save")
    Inmobiliaria save(@RequestBody Inmobiliaria user) throws ClassNotFoundException {
    	System.out.println("llego al server" + user + user.getNombre() + user.getPass());
    	
    	Inmobiliaria aux;
    	if (Objects.isNull(user.getId())) {
    	
    	aux = new Inmobiliaria(user.getNombre(), user.getPass(), user.getAlias());

    }else aux= user;
    	
        return inmobiliariaRepository.save(aux);

    }
    
	
	  @PostMapping("/pago/save") Pago save(@RequestBody Pago pago) {
	  return pagoRepository.save(pago); }
	  
	  @PostMapping("/login") Inmobiliaria login(@RequestBody Login user ) {
		  Inmobiliaria idResp = new Inmobiliaria() ;
//		  if (user.getNombre().equals("admin") && user.getPass().equals("admin")) {
//			  idResp.setId(Long.valueOf(0));
//			  idResp.setNombre("Admin");
//			  return idResp;
//		  }
		  idResp = inmobiliariaRepository.loginInmo(user.getNombre(), user.getPass());
		  if ( Objects.isNull(idResp)) throw new ResponseStatusException(
	                HttpStatus.NOT_FOUND);
		  return idResp;
				  }
	 
    
    @DeleteMapping("/inmobiliaria/delete/{id}")
    public Map<String, Boolean> deleteInmobiliaria(@PathVariable(value = "id") Long id)
         throws ResourceNotFoundException {
        Inmobiliaria inmob = inmobiliariaRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Inmobiliaria not found for this id :: " + id));

        inmobiliariaRepository.delete(inmob);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
