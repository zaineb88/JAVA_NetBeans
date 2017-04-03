/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioconcesionario;

/**
 *
 * @author profesoraula
 */
public class Coche {

    private int id;
    private String marca;
    private String modelo; 
    private int kilometraje;
    private float precio;
    private boolean esSegunda = false;

    public Coche(){}
    public Coche(int id, String marca, String modelo, int kilometraje, float precio, boolean esSegunda) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.precio = precio;
        this.esSegunda = esSegunda;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
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
