/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coches;

import java.util.Scanner;

/**
 *
 * @author alumno2
 */
public class Menu {
    
    
        public static void mostrarMenu(){
        System.out.println("1- Crear nuevo coche");
     System.out.println("2-Listar todos los coches");
     System.out.println("3-Actualizar un coche");
     System.out.println( "4-Borra un coche");
     System.out.println("0-Salir");
     
     Scanner scn = new Scanner(System.in);
        System.out.println("Elige un numero del menu");
         int numMenu = Integer.valueOf(scn.nextLine());

         Metodos metodos=new Metodos();
     switch(numMenu)
     {  case 1:
         //llama al metodo de crear coche
       metodos.crearCoche();
         break;
         
     case 2:
         //llama al metodo de listar coches
         System.out.println("listando");
         metodos.listarCoches();
         break;
         
     case 3:
         //llama al metodo actualizar 
         
         break;
         
     case 4:
         //llama al metodo borra coche 
         metodos.borra();
         break;
         
     case 0:
         // salir
         System.exit(0);
         break;
         
         default:
             System.out.println("Losiento ha eligido un numero que no existe en el menu");
     }
    }
      public static void main(String[] args) {
        mostrarMenu();
    }
}

