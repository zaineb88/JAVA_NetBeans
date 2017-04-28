/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplos;

import java.util.Scanner;
import javax.naming.NameNotFoundException;
import prueba1.Persona;



/**
 *
 * @author alumno2
 */
public class DibujarPiramide {
  
       public static void main(String [] args)    
   {
       
         /////////////// dibujar piramide con #
       
       
             Scanner scn = new Scanner(System.in);
        System.out.println("Escribe el número de pisos");
        try{
        int pisos = Integer.valueOf(scn.nextLine());
        
        // Iteramos a través del número de pisos
        int asteriscos = 1;
        int espacios = pisos;
        
        for(int i=0;i<pisos;i++){
            
            // Dibujamos los espacios
            for(int j=0;j<espacios;j++){
                System.out.print(" ");
            }
            
            // Dibujamos los asteriscos
            for(int j=0;j<asteriscos;j++){
                System.out.print("*");
            }
            
            // Añadimos dos asteriscos, restamos un
            // espacio, y realizamos un salto de línea
            System.out.println("");
            asteriscos += 2;
            espacios--;
        }
        
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        

       ////////////////////// con otra manera 
          int altura=5;
    int esp=altura-1;
    int ast = 1;
    for (int i=0; i<altura; i++) {
        for (int j=0; j<esp; j++) {
            System.out.print(' ');
        }
        for (int j=0; j<ast;j++) {
            System.out.print('#' );
        }
        System.out.println();
        esp--;
        ast += 2;
    }
              
}

   }
}
