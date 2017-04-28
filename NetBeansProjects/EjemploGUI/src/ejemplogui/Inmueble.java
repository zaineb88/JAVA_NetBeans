/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplogui;

/**
 *
 * @author profesoraula
 */
public class Inmueble {
    
    private int metros;
    private String direccion;
    private String tipo;

    public Inmueble(){}
    public Inmueble(int metros, String direccion, String tipo) {
        this.metros = metros;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    /**
     * @return the metros
     */
    public int getMetros() {
        return metros;
    }

    /**
     * @param metros the metros to set
     */
    public void setMetros(int metros) {
        this.metros = metros;
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
