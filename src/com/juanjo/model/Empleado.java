package com.juanjo.model;

public class Empleado extends Persona{
    
    private int categoria;
    public int anyos;
    
    

    /**
     * Constructor 1 de la clase Empleado
     * @param categoria
     * @param anyos
     * @param nombre
     * @param dni
     * @param sexo
     * @throws DatosNoCorrectosException 
     */
    
    
    public Empleado(int categoria, int anyos, String nombre, String dni, char sexo) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);
        
        
         //Condicion de integridad  para la propiedad categoria, tiene 
         //que estar incluidad entre 1 y 10. En caso contrario se lanza 
         //una expecpcion.
         
        
        
        if (categoria<1 || categoria>10) {
            
            throw new DatosNoCorrectosException("Datos no correctos");
        } else {
            this.categoria = categoria;
        }
        
        
         //Condicion de integridad  para la propiedad anyos, tiene 
         //que ser positiva. En caso contrario se lanza una excepcion.
         
        
        if (anyos<0) {
            throw new DatosNoCorrectosException("Datos no correctos");
        } else {
            this.anyos = anyos; 
        }
    }
    
    /**
     * Constructor 2 para la clase empleado
     * @param nombre
     * @param dni
     * @param sexo 
     */

    
    public Empleado(String nombre, String dni, char sexo) {
        super(nombre, dni, sexo);
        this.categoria = 1;
        this.anyos = 0;
    }

    /**
     * Getter Categoria
     * @return 
     */
    
    
    
    
    /**
     * Metodo para incrementar a�os
     */
    public void incrAnyo (){
    
        anyos = anyos +1;
    
    }
    
    public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getAnyos() {
		return anyos;
	}

	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}

	/**
     * Metodo imprime
     */
    public void imprime (){
    
        System.out.println("nombre: "+nombre+" sexo: "+sexo+" dni: "+dni+" categoria: "+categoria+" a�os: "+anyos);
    
    }
    
}
