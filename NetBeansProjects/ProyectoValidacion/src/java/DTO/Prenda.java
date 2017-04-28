/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author profesoraula
 */
public class Prenda {
    
    private String nombre;
    private String generoObjetivo;
    private int precio;
    private String imagen;
 
    Prenda(){}

    public Prenda(String nombre, String generoObjetivo, int precio, String imagen) {
        this.nombre = nombre;
        this.generoObjetivo = generoObjetivo;
        this.precio = precio;
        this.imagen = imagen;
    }

    /**
     * @return the nombre
     */
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
     * @return the generoObjetivo
     */
    public String getGeneroObjetivo() {
        return generoObjetivo;
    }

    /**
     * @param generoObjetivo the generoObjetivo to set
     */
    public void setGeneroObjetivo(String generoObjetivo) {
        this.generoObjetivo = generoObjetivo;
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
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
    
}
