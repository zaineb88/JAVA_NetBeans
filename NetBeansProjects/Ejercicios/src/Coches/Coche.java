/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coches;

/**
 *
 * @author alumno2
 */
public class Coche {
   
    private String marca;
    private String modelo;
    private int precio;
    private float kilometraje;
    private boolean segundamano;
    
    Coche(){}
    
    public Coche (String marca,String modelo,int precio,float kilometraje,boolean segundamano)
    {
        this.marca=marca;
        this.modelo=modelo;
        this.precio=precio;
        this.kilometraje=kilometraje;
        this.segundamano=segundamano;
    }
    
    public void mostrarCoche ()
	{
		System.out.println("marca = " + getMarca());
		System.out.println("modelo = " + this.getModelo());
                System.out.println("precio = " + this.getPrecio());
                System.out.println("kilopetraje = " + this.getKilometraje());
                 System.out.println("segundamano = " + this.getSegundamano());
	}

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the kilometraje
     */
    public float getKilometraje() {
        return kilometraje;
    }

    /**
     * @param kilometraje the kilometraje to set
     */
    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    /**
     * @return the segundamano
     */
    public boolean getSegundamano() {
        return segundamano;
    }

    /**
     * @param segundamano the segundamano to set
     */
    public void setSegundamano(boolean segundamano) {
        this.segundamano = segundamano;
    }
    
    
    
  
    
    
}
