/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.CRUD;
import DB.Conector;
import DTO.Prenda;
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
public class PrendaDAO implements CRUD{

    Conector c;
    
    public PrendaDAO(Conector c ){
        this.c = c;
    }
    
    @Override
    public void create(Object o) {

        try {
            Prenda p = (Prenda) o;
            Connection conn = c.getConnection();
            PreparedStatement st = conn.prepareStatement
                        ("INSERT INTO PRENDAS (nombre, precio, genero, imagen) VALUES (?,?,?,?)");
            st.setString(1, p.getNombre());
            st.setInt(2, p.getPrecio());
            st.setString(3, p.getGeneroObjetivo());
            st.setString(4, p.getImagen());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            c.closeConnection();
        }
        
    }

    @Override
    public Object read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList readAll() {
      ArrayList<Prenda> lista = null;
      try {
            Connection conn = c.getConnection();
            PreparedStatement st = conn.prepareStatement
                        ("SELECT * FROM PRENDAS");
            ResultSet rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                lista.add(
                    new Prenda(
                      rs.getString("nombre"),
                      rs.getString("genero"),
                      rs.getInt("precio"),
                      rs.getString("imagen")
                    )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            c.closeConnection();
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
