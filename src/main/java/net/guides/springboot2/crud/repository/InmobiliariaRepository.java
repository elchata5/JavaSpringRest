package net.guides.springboot2.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.crud.model.Inmobiliaria;

@Repository
public interface InmobiliariaRepository extends JpaRepository<Inmobiliaria, Long>{

	@Query("SELECT c FROM Inmobiliaria c WHERE c.nombre= :nombre and c.pass= :pass")
	Inmobiliaria loginInmo(@Param("nombre")String nombre, @Param("pass")String pass);
	
}
