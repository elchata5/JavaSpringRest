package net.guides.springboot2.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "inmueble")
public class Inmueble implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "num" , nullable = false)
	private int num;
	
	@Column(name = "depto", nullable = true)
	private String depto = null;
	
	@Column(name = "piso", nullable = true)
	private String piso = null;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idInmobiliaria", nullable = false)
	private Inmobiliaria inmobiliaria;
	
	@JsonBackReference (value= "duenio")
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idPropietario", nullable = false)
	private Persona propietario;
	
	  @ManyToOne(fetch=FetchType.LAZY) 
	  @JoinColumn(name = "idInquilino", nullable = true) 
	  private Persona inquilino;
	 
	
	public Inmueble() {
	}

	public Inmueble(String direccion, int num, String depto , String piso, Persona propietario, Inmobiliaria inmobiliaria) {
		super();
		this.direccion = direccion;
		this.num = num;
		this.depto = depto;
		this.piso = piso;
		this.propietario = propietario;
		this.inmobiliaria = inmobiliaria;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}
	
	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}
	
	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	
	  public Persona getInquilino() { return inquilino; }
	  
	  public void setInquilino(Persona inquilino) { this.inquilino = inquilino; }

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}  
	
	public String getDuenio() {
		return this.getPropietario().getApellido() +' ' + this.getPropietario().getNombre();
	}
	
	public Long getIdDuenio() {
		return this.getPropietario().getId();
	}
}
