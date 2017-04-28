/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.CRUD;
import DB.Conector;
import DTO.Mensaje;
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
public class MensajeDAO{
   
    Conector c = null;
    public MensajeDAO(Conector c){
        this.c = c;
    }
    
    public ArrayList<Mensaje> obtenerMensajes(int leido){
        
            ArrayList<Mensaje> lista = null;
      try {
            Connection conn = c.getConnection();
            PreparedStatement st = conn.prepareStatement
                        ("SELECT ID,contenido,autor,fecha,leido FROM MENSAJES WHERE leido = "+leido);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                if(lista == null) {
                    lista = new ArrayList();
                }
                lista.add(
                    new Mensaje(
                        rs.getInt("ID"),
                        rs.getString("autor"),
                        rs.getString("contenido"),
                        rs.getDate("fecha"),
                        rs.getInt("leido")    
                    )
                );
                for(Mensaje m : lista){
                    System.out.println(m.getAutor()+", "+m.getContenido());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            c.closeConnection();
        }
      return lista;
        
    }

    public void updateLeidos(ArrayList<Mensaje> lista){
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<lista.size();i++){
            if(i<lista.size()-1){
               sb.append(lista.get(i).getId()).append(',');
            }else{
               sb.append(lista.get(i).getId());
            }
        }
        
        try {
            Connection conn = c.getConnection();
            PreparedStatement st = conn.prepareStatement
                                ("UPDATE MENSAJES SET leido=1 WHERE ID IN ("+sb.toString()+")");
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MensajeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public int messageMaxId(){
    
        int max = 0;
        try {
            Connection conn = c.getConnection();
            PreparedStatement st = conn.prepareStatement
                                        ("SELECT MAX(ID) FROM MENSAJES");
            ResultSet rs = st.executeQuery();
            rs.next();
            max = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(MensajeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            c.closeConnection();
        }
        return max;
    }
    
    
    public void insertarMensaje(Mensaje m){
            
        int id = messageMaxId()+1;
        try {
            Connection conn = c.getConnection();
            PreparedStatement st = conn.prepareStatement
                                ("INSERT INTO MENSAJES (id, autor, contenido, leido) VALUES (?, ?, ?, 0)");
            st.setInt(1, id);
            st.setString(2, m.getAutor());
            st.setString(3, m.getContenido());
            st.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
            Logger.getLogger(MensajeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           // c.closeConnection();
        }
        
        
    }
}
