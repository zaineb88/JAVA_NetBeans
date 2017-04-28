/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author alumno2
 */
public class Moto extends Vehiculo{
    
    private int cilindrada;
    private String tipo;  
    
    
    public Moto(){}
    
    
    public Moto(int cilindrada, String tipo, String marca,String modelo, float precio,int id) {
         super(marca, modelo, precio);
        this.cilindrada = cilindrada;
        this.tipo = tipo;
          setId(id);
    }

   

    
    
    /**
     * @return the cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * @param cilindrada the cilindrada to set
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
