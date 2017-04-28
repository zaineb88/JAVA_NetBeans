/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno2
 */
public class Prueba1 {

   
    public static void main(String[] args) throws IOException { 
        
        final int CONSTANTE=55;  //constante siempre majuscula 
        
        int numero =5;
        
        float dicemal =10.30f;
        
        long numeroGrade=3515486651L; //camel case
        
        
        double decimal_grade =5135.5161356; //simple case
        
        char letra='a';
        
        String texto= "HOLA QUE TAL";
        
       boolean hecho =false;
       
       if(5 > 3 && 3 == 1 || 1!=0){
           
       }
       
       switch(letra)
       {
           case 'a':
           break;
           case 'b':
           break;
           default:
       }
       
       int [] nums = {5,3,1,7,8};
       
       for(int n:nums){
           System.out.println("  "+n);
      
               }
        System.out.println("prueba1.Prueba1.main()");
        
        ////////////////////////////////////////////

        ///////////////////
    }
    
}
