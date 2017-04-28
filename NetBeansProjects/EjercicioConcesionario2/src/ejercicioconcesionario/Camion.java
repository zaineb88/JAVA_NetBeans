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
public class Camion extends Vehiculo{
    
    private int carga;
    
    public Camion(){}
    public Camion(int carga, String marca, String modelo, float precio, int id) {
        super(marca, modelo, precio);
        this.carga = carga;
        setId(id);
    }

   
    @Override
    public String toString(){
        return "["+getId()+"] CAMIÓN - "+getMarca()+" "+getModelo()+", "+getPrecio()+"€";
    }
    
    
    /**
     * @return the carga
     */
    public int getCarga() {
        return carga;
    }

    /**
     * @param carga the carga to set
     */
    public void setCarga(int carga) {
        this.carga = carga;
    }
    
    
}
