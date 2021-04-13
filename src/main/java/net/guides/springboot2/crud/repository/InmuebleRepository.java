package net.guides.springboot2.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import net.guides.springboot2.crud.model.Inmueble;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long>{
	
	@Query("SELECT c FROM Inmueble c WHERE c.inmobiliaria.id= :id ")
	List<Inmueble> getInmueblesByInmob(@Param("id")Long id);


}
