/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Persona;
import DBUtils.CRUD;
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
public class PersonaDAO implements CRUD{

    Connection c;
    public PersonaDAO(Connection c){
        this.c = c;
    }
    
    
    public int maxId(){
        int id = -1;
        try {
            PreparedStatement ps = c.prepareStatement
                        ("SELECT MAX(id) FROM PERSONAS");
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt(1);
            } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    @Override
    public void create(Object o) {
        Persona p = (Persona) o;
        int nextId = maxId()+1;
        if(nextId != -1){
            try {
                PreparedStatement ps = c.prepareStatement
                  ("INSERT INTO PERSONAS VALUES (?,?,?,?)");
                ps.setInt(1, nextId);
                ps.setString(2, p.getNombre());
                ps.setString(3, p.getDni());
                ps.setInt(4, p.getEdad());
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }

    @Override
    public Object read(int id) {
        Persona p = null;
        try {
            PreparedStatement ps = c.prepareStatement
                ("SELECT * FROM PERSONAS WHERE ID="+id);
           ResultSet rs =  ps.executeQuery();
           rs.next();
           p = new Persona();
           p.setId(id);
           p.setNombre(rs.getString("nombre"));
           p.setDni(rs.getString("dni"));
           p.setEdad(rs.getInt("edad"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public ArrayList readAll() {
        ArrayList<Persona> lista = null;
        try {
            PreparedStatement ps = c.prepareStatement(
                    "SELECT * FROM PERSONAS"
            );
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDni(rs.getString("dni"));
                p.setEdad(rs.getInt("edad"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void update(Object o) {
        Persona p = (Persona) o;
        try {
            PreparedStatement ps = c.prepareStatement
                        ("UPDATE PERSONAS SET"
                                + " nombre=?, dni=?, edad=?"
                                + " WHERE ID="+p.getId());
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDni());
            ps.setInt(3, p.getEdad());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        
        try {
            PreparedStatement ps = c.prepareStatement
                        ("DELETE FROM PERSONAS WHERE ID="+id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
