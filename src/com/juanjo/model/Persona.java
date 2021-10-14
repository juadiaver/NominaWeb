package com.juanjo.model;

public class Persona {
    
    /**
     * Nombre del empleado: nombre
     * Dni del empleado: dni
     * Sexo del empleado: sexo
     */
    public String nombre;
    public String dni;
    public char sexo;
    
    
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDni() {
		return dni;
	}

	/**
     * Constructor 1 de la clase persona
     * @param nombre
     * @param dni
     * @param sexo 
     */
    public Persona(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }
    
    /**
     * Cronstructor 2 de la clase persona
     * @param nombre
     * @param sexo 
     */
    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }
    
    /**
     * Setter de DNI
     * @param dni 
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Creacion del  metodo imprime para imprimir los datos del empleado.
     */
    public void imprime () {
        System.out.println(nombre+' '+dni);
    }
    
}
