/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesoraula
 */
public class Conector {
    
    private String username;
    private String password;
    private String host;
    private int port;
    private String sid;
    
    private Connection conn = null;

    public Conector(String username, String password, String host, int port, String sid) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.sid = sid;
    }
    
    
    private void connect() throws ClassNotFoundException, SQLException{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection
                ("jdbc:oracle:thin:@"+host+":"+port+":"+sid, username, password); 
    }
    
    public Connection getConnection(){
        Connection c = null;
        if(conn != null){
            c = conn; 
        }else{
            try {
                connect();
                c = conn;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println("[DB] Error al obtener conexión al servidor");
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
    }
    
    public void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("[DB] Error al cerrar conexión");
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                conn = null;
            }
        }
        
    }
    
    
}
