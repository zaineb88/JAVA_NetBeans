/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author profesoraula
 */
public class ContainerService {
    
    private String query;
    private String variable;
    
    private DefaultTableModel modelo;

    /**
     * @return the query
     */
    public synchronized String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public synchronized void setQuery(String query) {
        this.query = query;
    }

    /**
     * @return the variable
     */
    public synchronized String getVariable() {
        return variable;
    }

    /**
     * @param variable the variable to set
     */
    public synchronized void setVariable(String variable) {
        this.variable = variable;
    }

    /**
     * @return the modelo
     */
    public synchronized DefaultTableModel getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public synchronized void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
    
    
}
