package net.guides.springboot2.crud.model;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name = "pago")
public class Pago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonBackReference (value= "inmobiliaria-pago")
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idInmobiliaria", nullable = false)
	private Inmobiliaria inmobiliaria;
	
	@Column(name = "fechaPago", nullable = false)
	private Date fechaPago;
	
	@Column(name = "fechaFin", nullable = false)
	private Date fechaFin;
	
	@Column(name = "monto", nullable = false)
	private int monto;

	public Pago() {
		
	};
	
	public Pago(Inmobiliaria inmobiliaria, Date fechaPago, Date fechaFin, int monto) {
		super();
		this.inmobiliaria = inmobiliaria;
		this.fechaPago = fechaPago;
		this.fechaFin = fechaFin;
		this.monto = monto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
	

}
