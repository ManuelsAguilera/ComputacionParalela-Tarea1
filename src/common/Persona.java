package common;

import java.io.Serializable;


public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int edad;
	private String nombre;
	
	public Persona(String nombre, int edad)
	{
		this.edad = edad;
		this.nombre = nombre;
	}

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
