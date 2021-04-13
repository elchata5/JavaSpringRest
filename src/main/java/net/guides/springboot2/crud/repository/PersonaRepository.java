package net.guides.springboot2.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.crud.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	@Query("SELECT c FROM Persona c WHERE c.inmobiliaria.id= :id ")
	List<Persona> getPersonasByInmob(@Param("id")Long id);

}
