/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcprueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno2
 */
public class JDBCPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  try {
            final String USERNAME = "SYSTEM";
            final String PASSWORD = "root";
            final String HOST = "localhost";
            final int PORT = 1521;
            final String SID = "orcl";
            
            Connection connection = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection
                ("jdbc:oracle:thin:@"+HOST+":"+PORT+":"+SID, USERNAME, PASSWORD);
       
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCPrueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
