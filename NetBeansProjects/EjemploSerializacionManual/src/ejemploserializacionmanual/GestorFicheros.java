/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploserializacionmanual;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesoraula
 */
public class GestorFicheros {
    
    String ruta;
    
    public GestorFicheros(String ruta){
        this.ruta = ruta;
    }
    
    
    public String leerFichero(){
        
        String resultado = null;
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(ruta));
            StringBuilder sb = new StringBuilder();
            String temp;
            
            while((temp = buff.readLine()) != null){
                sb.append(temp);
            }
            
            resultado = sb.toString();
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: Fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }finally{
            try {
                buff.close();
            } catch (IOException ex) {
                System.out.println("ERROR: "+ex.getMessage());
            }
        }
        
        return resultado;
    }
    
    
    public void escribirFichero(String s){
        BufferedWriter buff = null;
        try {
            buff = new BufferedWriter(new FileWriter(ruta));
            buff.write(s);
        
        } catch (IOException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }finally{
            try {
                buff.close();
            } catch (IOException ex) {
                System.out.println("ERROR: "+ex.getMessage());
            }
        }
        
    }
    
    
}
