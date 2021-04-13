package net.guides.springboot2.crud.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "inmobiliaria")
public class Inmobiliaria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", unique = true)
	private String nombre;
	
	
	@Column(name = "pass")
	private String pass;
	
	@Column(name = "activa")
	private Boolean activa;
	
	@JsonIgnore
    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL , fetch=FetchType.LAZY)
	private List<Inmueble> inmuebles ;
	
	@JsonManagedReference (value= "personas")
    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL , fetch=FetchType.LAZY)
	private List<Persona> personas ;
	
	@JsonIgnore
    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL , fetch=FetchType.LAZY)
	private List<Pago> pagos;
	
	@Column(name = "alias")
	private String alias;
	
	public Inmobiliaria() {
	}

	public Inmobiliaria(String nombre, String pass, String alias) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.alias = alias;
		this.activa = true ;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}
	
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public List<Pago> getPagos() {
		return pagos;
	}
	
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public String getUltimoPago() {
		List<Pago> pagosaux = this.getPagos();
		if (pagosaux.size() > 0) 
		return new SimpleDateFormat("MM/dd/yyyy").format(pagosaux.get(pagos.size() -1 ).getFechaFin());
		return null;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
}
