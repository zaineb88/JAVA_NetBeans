/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_tarea;

import java.util.Date;

/**
 *
 * @author alumno2
 */
public class ClaseTareas {
    private String  tarea;
    private String ficha;

    public ClaseTareas(String tarea,String ficha) {
        this.tarea = tarea;
        this.ficha = ficha;
    }
    
    public ClaseTareas(){}

    /**
     * @return the tarea
     */
    public String getTarea() {
        return tarea;
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    /**
     * @return the ficha
     */
    public String getFicha() {
        return ficha;
    }

    /**
     * @param ficha the ficha to set
     */
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }
}
