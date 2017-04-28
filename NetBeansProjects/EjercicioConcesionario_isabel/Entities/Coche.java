/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author profesoraula
 */
public class Coche extends Vehiculo{

    private int kilometraje;
    private boolean esSegunda = false;

    public Coche(){}

    public Coche(int kilometraje, String marca, String modelo, float precio, boolean esSegunda, int id) {
        super(marca, modelo, precio);
        this.kilometraje = kilometraje;
        this.esSegunda = esSegunda;
        setId(id);
    }

 
    

    @Override
    public String toString(){
        return "["+getId()+"] COCHE - "+getMarca()+" "+getModelo()+", "+getPrecio()+"€";
    }

    /**
     * @return the kilometraje
     */
    public int getKilometraje() {
        return kilometraje;
    }

    /**
     * @param kilometraje the kilometraje to set
     */
    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    /**
     * @return the esSegunda
     */
    public boolean isEsSegunda() {
        return esSegunda;
    }

    /**
     * @param esSegunda the esSegunda to set
     */
    public void setEsSegunda(boolean esSegunda) {
        this.esSegunda = esSegunda;
    }
  
    
}
