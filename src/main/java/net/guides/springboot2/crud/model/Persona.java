package net.guides.springboot2.crud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "persona")
public class Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "dni", nullable = false, unique = true)
	private int dni;
	

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL , fetch=FetchType.LAZY)
	@JsonManagedReference (value= "duenio")
	private List<Inmueble> propiedades;
	
	@JsonBackReference (value= "personas")
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idInmobiliaria", nullable = false)
	private Inmobiliaria inmobiliaria;

	@JsonIgnore
	@OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL, fetch=FetchType.LAZY) 
	private List<Inmueble> alquileres;
	 
	public Persona() {
	}
	
	public Persona(String nombre, String apellido, int dni, Inmobiliaria inmob) {
		super();
		this.inmobiliaria = inmob;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public List<Inmueble> getPropiedades() {
		return propiedades;
	}
	

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public void setPropiedades(List<Inmueble> propiedades) {
		this.propiedades = propiedades;
	}
	
	  public List<Inmueble> getAlquileres() { return alquileres; }
	  
	  public void setAlquileres(List<Inmueble> alquileres) { this.alquileres =
	  alquileres; }
	 
}
