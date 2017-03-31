/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coches;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno2
 */
public class Metodos {
    
 
   
	
	private ArrayList<Coche> lista_coches=new ArrayList<Coche>();
	
        Metodos(){
            reanarLista(); 
        }
        
              public void crearCoche()
             {
              Scanner scn = new Scanner(System.in);
              System.out.println("Escribe la marca del coche");
              String marca;
              marca = scn.nextLine();
              
              Scanner scn2 = new Scanner(System.in);
              System.out.println("Escribe el modelo del coche");
      
                String modelo;
            modelo = scn2.nextLine();
            
            Scanner scn3 = new Scanner(System.in);
              System.out.println("Escribe el precio del coche");
      
                int precio;
            precio =  Integer.valueOf(scn3.nextLine());
            
            Scanner scn4 = new Scanner(System.in);
              System.out.println("Escribe el kilometraje del coche");
      
                float kilometraje;
            kilometraje = Integer.valueOf( scn4.nextLine());
             
            boolean segundamano;
            String segundamano1;
                  Scanner scn5 = new Scanner(System.in);
              System.out.println("Escribe si es el coche de segunda mano");
              segundamano1 =scn5.nextLine();
              if(segundamano1.equals("si"))
              {segundamano=true;}
              else{segundamano=false;}
            Coche coche=new Coche(marca,modelo,precio,kilometraje,segundamano);
            coche.mostrarCoche();
            lista_coches.add(coche);
         	Menu.mostrarMenu();
             }
              
              public void reanarLista()
              {
                Coche coche1=new Coche("mercedez","m1245",21547,121457,true);
                Coche coche2=new Coche("fiat","f1245",21547,121457,false);
                Coche coche3=new Coche("ibisa","i1245",21547,121457,true);
                Coche coche4=new Coche("polo","p245",21547,121457,false);
                Coche coche5=new Coche("rono","r12k",21547,121457,true);
                
              lista_coches.add(coche1);
              lista_coches.add(coche1);
              lista_coches.add(coche3);
              lista_coches.add(coche4);
              lista_coches.add(coche5);
              }
       
                
	////////////////



	
        
	public void listarCoches ()
	{
           /* 
            }*/
            int i=1;
              for(Coche c : lista_coches){
                System.out.println("LA MARCA DEL COCHE "+i+" "+c.getMarca());
                 System.out.println("EL MODELO DEL COCHE "+i+" "+c.getModelo());
                  System.out.println("EL PRECIO DEL COCHE "+i+" "+c.getPrecio());
                   System.out.println("LOS KILOMETRAJES DEL COCHE "+i+" "+c.getKilometraje());
                    System.out.println("EL COCHE ES DE SEGUNDAMANO "+i+" "+c.getSegundamano());
                    System.out.println("-------------------");
                    
                    i++;
            }
		Menu.mostrarMenu();
        }
        
        public void borra()
        { 
                int con = 0;
		int hay=0;
		
	           Scanner scn = new Scanner(System.in);
              System.out.println("Escribe la marka del coche que quiere borrar");
      
                String nombre_marca;
                nombre_marca = scn.nextLine();
		
		while ((con < lista_coches.size()) && (nombre_marca !=lista_coches.get(con).getMarca()))
                {
			
 
			if (lista_coches.get(con).getMarca().equalsIgnoreCase(nombre_marca)) {
                          //      lista_coches.get(con)=lista_coches.get(con+1);
                          
			hay++;	
			}

			con++;
		}
		
		
		if(hay==0)
				
		System.out.println("El coche que ha elegido no existe");
			Menu.mostrarMenu();

        }
}
