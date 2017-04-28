/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import DAO.PersonaDAO;
import Entities.Persona;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesoraula
 */
public class SearchThread implements Runnable {
    
    final String URL = "localhost";
    final String USER = "SYSTEM";
    final String PW = "root";
    final int PORT = 1521;
    final String SID = "orcl";
    
    Conector c = new Conector(USER, PW, URL, PORT, SID);
    PersonaDAO dao = new PersonaDAO(c.getConnection());
    
    ContainerService cont;
    
    public SearchThread(ContainerService cont){
        this.cont = cont;
    }

    @Override
    public void run() {

        synchronized(cont){
            while(true){
                
                String variable = cont.getVariable();
                String query = cont.getQuery();
                ArrayList<Persona> lista = dao.searchByQuery(variable, query);   
                cont.getModelo().setRowCount(0);
                
                for(Persona p : lista){
                    cont.getModelo().addRow(
                         new Object[]{p.getId(), p.getNombre(), p.getDni(), p.getEdad()}
                    ); 
                }
               
                try {
                    cont.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SearchThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    
    
    
}
