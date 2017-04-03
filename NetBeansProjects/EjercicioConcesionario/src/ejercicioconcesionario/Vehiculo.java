/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioconcesionario;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno2
 */
public class Vehiculo {
    
    private int id;
    private String marca;
    private String modelo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    

/////////////////////////////////////////////////////////////


     
    static ArrayList<Camion> camiones = new ArrayList();
    static int contador = 0;
    
    public static void main(String[] args) {
       
        int opcion = -1;
        
        while(opcion != 0){
            
           opcion = mostrarMenu();
           switch(opcion){
               
               case 1: // Creación de coche
                       crearCoche();
                       break;
                   
               case 2: // Listado
                       listado();
                       break; 
                   
               case 3: // Actualizar
                       actualizarCamion();
                       break;
                   
               case 4: // Borrar
                        borrarCoche();
                 
           } 
            
        }
        
        
        
    }
    
    public static int mostrarMenu(){

       int opcion = pedirInt("Selecciona una opción de la lista\n"
                + "1 - Crear un camion nuevo\n"
                + "2 - Listar todos los camiones\n"
                + "3 - Actualizar un camion\n"
                + "4 - Borrar un camion\n"
                + "0 - Salir de la aplicación\n");
        
        if(opcion > 4 | opcion < 0){
            JOptionPane.showMessageDialog(null, "Has insertado un valor incorrecto");
            mostrarMenu();
        }
        return opcion;
       
    }
    
    
    public static void actualizarCamion(){
        
        listado();
        int id = pedirInt("¿Qué ID de coche quieres modificar?");
        Camion camionObjetivo = null;
        
        for(Camion cam : camiones){
            if(id == cam.getId()){
                int index = camiones.indexOf(cam);
                camionObjetivo = camiones.get(index);
            }
        }
        
        if(camionObjetivo == null){
            System.out.println("Camion no encontrado");
            actualizarCamion();
        }
        Scanner scn = new Scanner(System.in);
              System.out.println("Escribe la carga del camion");
             int carga;
              carga = Integer.valueOf(scn.nextLine());
        
              Scanner scn2 = new Scanner(System.in);
              System.out.println("Escribe la ejes del camion");
             int ejes;
              ejes = Integer.valueOf(scn.nextLine());
              
        camionObjetivo.getCarga();
        camionObjetivo.getEjes();
    }
   
    public static void borrarCoche(){
        
        listado();
        int id = pedirInt("¿Qué ID de camion quieres modificar?");
        boolean fallo = false;
        
        for(int i=0;i<camiones.size();i++){
            Camion coc = camiones.get(i);
            if(id == coc.getId()){
                int index = camiones.indexOf(coc);
                camiones.remove(index);
            }else if(i == camiones.size()-1){
                System.out.println("Camion no encontrado");
                 borrarCoche();
            }

        }

    }
    
    
    
    public static void crearCoche(){
        
        Camion c = new Camion();
       
        c.setCarga(pedirInt("¿Cual es la carga del camion?"));
        c.setEjes(pedirInt("¿Cuánto ejes tiene el camion?"));
      
        c.setId(++contador);
        
        camiones.add(c);
        JOptionPane.showMessageDialog(null, "Camion creado");
    }
    
 
    
    public static void listado(){
        for(int i=0;i<camiones.size();i++){
            Camion c = camiones.get(i);
            System.out.println(c.getId()+" - "+c.getCarga()+" "+c.getEjes()+" ");
        }
    }
    
    public static int pedirInt(String mensaje, String valorAnterior){
        try{
            if(valorAnterior != null){
                return Integer.valueOf(JOptionPane.showInputDialog(mensaje, valorAnterior));
            }else{
                return Integer.valueOf(JOptionPane.showInputDialog(mensaje));
            }
        }catch(NumberFormatException e){
            System.out.println("Escribe un número válido");
            return pedirInt(mensaje, valorAnterior);
        }
    }
    
    public static int pedirInt(String mensaje){
        return pedirInt(mensaje, null);
    }
    
    public static float pedirFloat(String mensaje){
        return pedirFloat(mensaje, null);
    }
    
    public static float pedirFloat(String mensaje, String valorAnterior){
        try{
            if(valorAnterior != null){
        return Float.valueOf(JOptionPane.showInputDialog(mensaje, valorAnterior));
            }else{
        return Float.valueOf(JOptionPane.showInputDialog(mensaje));
            }
            }catch(NumberFormatException e){
                System.out.println("Escribe un número válido");
                return pedirFloat(mensaje);
        }
    }
}