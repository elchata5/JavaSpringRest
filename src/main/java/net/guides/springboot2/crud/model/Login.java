package net.guides.springboot2.crud.model;

public class Login {

	String nombre;
	String pass;
	
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
	
	public Login(String nombre, String pass) {
		super();
		this.nombre = nombre;
		this.pass = pass;
	}
	
	
}
