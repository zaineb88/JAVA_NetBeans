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
    static ArrayList<Vehiculo> vehiculos = new ArrayList();
    static int contador = 0;
    
    static GestorFicheros ficheros = new GestorFicheros("objetos.txt");
    static Codificador codificador = new Codificador();
    
    public static void main(String[] args) {
       
        
        String data = ficheros.leerFichero();
        if(data != null){
            vehiculos = codificador.descodificar(data);
        }
        
        int opcion = -1;
        
        while(opcion != 0){
            
           opcion = mostrarMenu();
           switch(opcion){
               
               case 1: // Creación de coche
                       crearVehiculo();
                       ficheros.escribirFichero(
                               codificador.codificar(vehiculos)
                       );
                       break;
                   
               case 2: // Listado
                       listado();
                       break; 
                   
               case 3: // Actualizar
                       actualizarVehiculo();
                       ficheros.escribirFichero(
                               codificador.codificar(vehiculos)
                       );
                       break;
                   
               case 4: // Borrar
                        borrarVehiculo();
                        ficheros.escribirFichero(
                               codificador.codificar(vehiculos)
                        );
                 
           } 
            
        }
        
        
        
    }
    
    public static int mostrarMenu(){

       int opcion = pedirInt("Selecciona una opción de la lista\n"
                + "1 - Crear un vehiculo nuevo\n"
                + "2 - Listar todos los vehiculo\n"
                + "3 - Actualizar un vehiculo\n"
                + "4 - Borrar un vehiculo\n"
                + "0 - Salir de la aplicación\n");
        
        if(opcion > 4 | opcion < 0){
            JOptionPane.showMessageDialog(null, "Has insertado un valor incorrecto");
            mostrarMenu();
        }
        return opcion;
       
    }
    
    
    public static void actualizarVehiculo(){
        
        listado();
        int id = pedirInt("¿Qué ID de vehículo quieres modificar?");
        Vehiculo v = null;
        
        for(Vehiculo vehiculo : vehiculos){
            if(id == vehiculo.getId()){
                int index = vehiculos.indexOf(vehiculo);
                v = vehiculos.get(index);
            }
        }
        
        if(v == null){
            System.out.println("Vehículo no encontrado");
            actualizarVehiculo();
        }
        
        if(v instanceof Coche){
            Coche cocheObjetivo = (Coche) v;
            cocheObjetivo.setMarca(JOptionPane.showInputDialog("Inserta la marca", cocheObjetivo.getMarca()));
            cocheObjetivo.setModelo(JOptionPane.showInputDialog("Inserta el modelo", cocheObjetivo.getModelo()));
            cocheObjetivo.setPrecio(pedirFloat("Inserta el precio", ""+cocheObjetivo.getPrecio()));
            cocheObjetivo.setKilometraje(pedirInt("Inserta el kilometraje", ""+cocheObjetivo.getKilometraje()));
        }else{
            Camion camionObjetivo = (Camion) v;
            camionObjetivo.setMarca(JOptionPane.showInputDialog("Inserta la marca", camionObjetivo.getMarca()));
            camionObjetivo.setModelo(JOptionPane.showInputDialog("Inserta el modelo", camionObjetivo.getModelo()));
            camionObjetivo.setPrecio(pedirFloat("Inserta el precio nuevo del camión", ""+camionObjetivo.getPrecio()));
            camionObjetivo.setCarga(pedirInt("Inserta la nueva carga del camión", ""+camionObjetivo.getCarga()));
        }
    }
   
    public static void borrarVehiculo(){
        
        listado();
        int id = pedirInt("¿Qué ID de vehículo quieres modificar?");
        boolean fallo = false;
        
        for(int i=0;i<vehiculos.size();i++){
            Vehiculo coc = vehiculos.get(i);
            if(id == coc.getId()){
                int index = vehiculos.indexOf(coc);
                vehiculos.remove(index);
            }else if(i == vehiculos.size()-1){
                System.out.println("Vehículo no encontrado");
                 borrarVehiculo();
            }

        }

    }
    
    
    
    public static void crearVehiculo(){
        
        int opcion = pedirInt("Pulsa 1 si quieres crear un coche\nPulsa 2 si quieres crear un camión");
        
        if(opcion == 1){
            Coche c = new Coche();
            c.setMarca(JOptionPane.showInputDialog("Escribe la marca del coche"));
            c.setModelo(JOptionPane.showInputDialog("Escribe el modelo del coche"));
            c.setPrecio(pedirFloat("Escribe el precio del coche"));
            c.setKilometraje(pedirInt("¿Cuánto kilometraje tiene el coche?"));
            c.setEsSegunda(esSegunda());
            c.setId(++contador);
            vehiculos.add(c);
            
        }else if(opcion == 2){
            Camion c = new Camion();
            c.setMarca(JOptionPane.showInputDialog("Escribe la marca del camion"));
            c.setModelo(JOptionPane.showInputDialog("Escribe el modelo del camion"));
            c.setPrecio(pedirFloat("Escribe el precio del camion"));
            c.setCarga(pedirInt("Escribe la carga máxima del camión"));
            c.setId(++contador);   
            vehiculos.add(c);
            
        }else{
            JOptionPane.showMessageDialog(null, "Has escogido una opción incorrecta");
            crearVehiculo();
        }
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
        for(Vehiculo v : vehiculos){
            System.out.println(v.toString());
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
