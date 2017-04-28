/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcpruebas;

import DAO.PersonaDAO;
import Entities.Persona;
import DBUtils.Conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author profesoraula
 */
public class JDBCPruebas {
    
    
    public static void main(String[] args) {
        
        Conector conector = new Conector
        ("SYSTEM", "root", "localhost", 1521, "orcl");
        
        Connection conn = conector.getConnection();
      //  inicializarApp(conn);
        PersonaDAO pDao = new PersonaDAO(conn);
        Persona per=new  Persona();
        ArrayList <Persona> lista = pDao.readAll();
        for(Persona p : lista){
            System.out.println("["+p.getId()+"] - "+p.getNombre()+" "+p.getDni()+" "+p.getEdad());
        }
        
       // pDao.update(per);
  
    
       }
    
    public static void inicializarApp(Connection c){
        
        if(c != null){
            try {
                PreparedStatement ps =
                        c.prepareStatement("CREATE TABLE PERSONAS (id int NOT NULL PRIMARY KEY, nombre VARCHAR2(30), dni VARCHAR2(12), edad int)");
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCPruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
    
}
