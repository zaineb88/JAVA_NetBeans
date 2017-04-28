/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesoraula
 */
public class UsuariosDAO {

    public static boolean checkCredentials(String user, String password){
        Conector c = new Conector("SYSTEM", "root", "localhost", 1521, "orcl");
        boolean result = false;
        
        try {
            Connection conn = c.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USUARIOS WHERE USERNAME=? AND PASSWORD=?");
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            if(rs != null){
              if(rs.next()){
                result = true;
              }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            c.closeConnection();
        }

        return result;
    }
    
    public static void createUser(String user, String password){
        
            Conector c = new Conector("SYSTEM", "root", "localhost", 1521, "orcl");
        try {
            Connection conn = c.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO USUARIOS (USERNAME, PASSWORD) VALUES (?, ?)");
            stmt.setString(1, user);
            stmt.setString(2, password);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            c.closeConnection();
        }
        
    }
    
    
}

