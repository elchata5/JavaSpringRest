package net.guides.springboot2.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.model.Pago;
import net.guides.springboot2.crud.repository.PagoRepository;

	@RestController
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/test")
	public class PagoController {
		

		@Autowired
		private PagoRepository pagoRepository;
		
		@GetMapping("/pagos")
		public List<Pago> getAllPagos() {
			return pagoRepository.findAll();
		}
		
		/*
		 * @PostMapping("/pago/save") Pago save(@RequestBody Pago user) {
		 * System.out.println(user); return pagoRepository.save(user); }
		 */

	}