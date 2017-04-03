/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploficheros;

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
public class EjemploFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
    
       
            
            // Ejemplo lectura de bytes
            try {
            FileInputStream fi = new FileInputStream("texto.txt");
            
            ArrayList<Integer> bytes = new ArrayList();
            int b = -1;
            while((b = fi.read()) != -1){
            bytes.add(b);
            }
            
            // fi.close(); // Cerrar stream
            for(int i : bytes){
            // Con el (char) casteamos el byte a su letra correspondiente
            System.out.print((char)i+" ");
            }
            
            } catch (FileNotFoundException ex) {
            Logger.getLogger(EjemploFicheros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(EjemploFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            // Leer caracteres de un fichero (línea a línea)
            try {
            BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
            StringBuilder sb = new StringBuilder();
            String linea;
            while((linea = br.readLine()) != null){
            sb.append(linea);
            }
            // br.close();  // Cerrar el stream
        
            System.out.println(sb.toString());
            
            } catch (FileNotFoundException ex) {
            Logger.getLogger(EjemploFicheros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(EjemploFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            // Escribir Strings directamente
        try {  
            BufferedWriter buff = new BufferedWriter(new FileWriter("texto_2.txt"));
             
            String texto = "Este es un texto con saltos de línea. \n\n Aquí hay más texto! \n Adiós";    String trim = texto.trim();
            String[] split = texto.split("\n");
            for(String s : split){
                buff.write(s);
                buff.newLine();
            }
            buff.close();
        
        } catch (IOException ex) {
            Logger.getLogger(EjemploFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
