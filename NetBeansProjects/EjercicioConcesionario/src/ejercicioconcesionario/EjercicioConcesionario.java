/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioconcesionario;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author profesoraula
 */
public class EjercicioConcesionario {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Coche> coches = new ArrayList();
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
                       actualizarCoche();
                       break;
                   
               case 4: // Borrar
                        borrarCoche();
                 
           } 
            
        }
        
        
        
    }
    
    public static int mostrarMenu(){

       int opcion = pedirInt("Selecciona una opción de la lista\n"
                + "1 - Crear un coche nuevo\n"
                + "2 - Listar todos los coches\n"
                + "3 - Actualizar un coche\n"
                + "4 - Borrar un coche\n"
                + "0 - Salir de la aplicación\n");
        
        if(opcion > 4 | opcion < 0){
            JOptionPane.showMessageDialog(null, "Has insertado un valor incorrecto");
            mostrarMenu();
        }
        return opcion;
       
    }
    
    
    public static void actualizarCoche(){
        
        listado();
        int id = pedirInt("¿Qué ID de coche quieres modificar?");
        Coche cocheObjetivo = null;
        
        for(Coche coc : coches){
            if(id == coc.getId()){
                int index = coches.indexOf(coc);
                cocheObjetivo = coches.get(index);
            }
        }
        
        if(cocheObjetivo == null){
            System.out.println("Coche no encontrado");
            actualizarCoche();
        }
        
         cocheObjetivo.setMarca(JOptionPane.showInputDialog("Inserta la marca", cocheObjetivo.getMarca()));
         cocheObjetivo.setModelo(JOptionPane.showInputDialog("Inserta el modelo", cocheObjetivo.getModelo()));
         cocheObjetivo.setPrecio(pedirFloat("Inserta el precio", ""+cocheObjetivo.getPrecio()));
         cocheObjetivo.setKilometraje(pedirInt("Inserta el kilometraje", ""+cocheObjetivo.getKilometraje()));

    }
   
    public static void borrarCoche(){
        
        listado();
        int id = pedirInt("¿Qué ID de coche quieres modificar?");
        boolean fallo = false;
        
        for(int i=0;i<coches.size();i++){
            Coche coc = coches.get(i);
            if(id == coc.getId()){
                int index = coches.indexOf(coc);
                coches.remove(index);
            }else if(i == coches.size()-1){
                System.out.println("Coche no encontrado");
                 borrarCoche();
            }

        }

    }
    
    
    
    public static void crearCoche(){
        
        Coche c = new Coche();
        c.setMarca(JOptionPane.showInputDialog("Escribe la marca del coche"));
        c.setModelo(JOptionPane.showInputDialog("Escribe el modelo del coche"));
        c.setPrecio(pedirFloat("Escribe el precio del coche"));
        c.setKilometraje(pedirInt("¿Cuánto kilometraje tiene el coche?"));
        c.setEsSegunda(esSegunda());
        c.setId(++contador);
        
        coches.add(c);
        JOptionPane.showMessageDialog(null, "Coche creado");
    }
    
    public static boolean esSegunda(){
        boolean s = false;
        String segunda = JOptionPane.showInputDialog("¿Es de segunda mano (S/N)?");
        if(segunda.equalsIgnoreCase("S")){
            s = true;
        }else if(!segunda.equalsIgnoreCase("N")){
            s = esSegunda();
        }
        return s;
    }
    
    public static void listado(){
        for(int i=0;i<coches.size();i++){
            Coche c = coches.get(i);
            System.out.println(c.getId()+" - "+c.getMarca()+" "+c.getModelo()+", precio: "+c.getPrecio());
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
