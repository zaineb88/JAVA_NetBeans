/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import Entities.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesoraula
 */
public class PersonasDAO implements CRUD {

    Conector c = new Conector("SYSTEM", "root", "localhost", 1521, "orcl");
    
    @Override
    public void create(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList readAll(int page) {
        ArrayList<Persona> lista = null;
        try {
            int limit = 10;
            int offset = page * limit; 
            
            Connection conn = c.getConnection();
            PreparedStatement stmt = conn.prepareStatement
                        ("SELECT * FROM PERSONAS OFFSET "+offset +" ROWS FETCH NEXT "+limit+" ROWS ONLY");
            ResultSet rs = stmt.executeQuery();
            
            lista = new ArrayList();
            if(rs != null){
                while(rs.next()){
                    Persona p = new Persona();
                    p.setId(rs.getInt("id"));
                    p.setEdad(rs.getInt("edad"));
                    p.setNombre(rs.getString("nombre"));
                    p.setDni(rs.getString("dni"));
                    lista.add(p);
                }
            }else{
                System.out.println("no data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
