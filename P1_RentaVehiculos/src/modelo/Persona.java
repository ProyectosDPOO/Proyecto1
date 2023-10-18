package modelo;

import java.io.File;

public class Persona {
	
	private String nombre;
	private String telefono;
	private String fechadeNacimiento;
	private String nacionalidad;
	private File documentodeIdentidad;
	
	
	public Persona(String nombre, String telefono, String fechadeNacimiento, String nacionalidad,
			File documentodeIdentidad) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechadeNacimiento = fechadeNacimiento;
		this.nacionalidad = nacionalidad;
		this.documentodeIdentidad = documentodeIdentidad;
	}
	
	

}


