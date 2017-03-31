/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import sun.applet.Main;

/**
 *
 * @author alumno2
 */
public class Persona {
 
    
    String frase="esto es una frase";
    private String nombre;
    private String dni;
    private int edad;
    private String direccion;
    
    
    Persona(){}
    
    public Persona (String nombre,String dni,int edad,String direccion)
    {
        this.nombre=nombre;
        this.dni=dni;
        this.edad=edad;
        this.direccion=direccion;
        
    }
    
    //////////////metodos propios

    @Override
    public String toString() {
     return getNombre()+"de dni"+getDni()+"y edad"+getEdad();
    }

    /**
     * @return the nombre
     */
    
    
    ////////////////// gets y sets 
    
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    /////////////////
    
   public static void main(String [] args)    
   {
       Persona p1=new Persona(
           "paco",
            "x12457c",
              25,
            "sjsjwkljwkl"); 

       
              
}
       
   }

 
           

