/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author profesoraula
 */
public class Mensaje {
    
    private int id;
    private String autor;
    private String contenido;
    private Date fecha;
    private int leido;

    public Mensaje(){}
    public Mensaje(String autor, String contenido){
        this.autor = autor;
        this.contenido = contenido;
    }
    public Mensaje(int id, String autor, String contenido, Date fecha, int leido) {
        this.id = id;
        this.autor = autor;
        this.contenido = contenido;
        this.fecha = fecha;
        this.leido = leido;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the leido
     */
    public int getLeido() {
        return leido;
    }

    /**
     * @param leido the leido to set
     */
    public void setLeido(int leido) {
        this.leido = leido;
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
    
    
}
