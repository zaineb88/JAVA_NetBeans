/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioconcesionario;

import java.util.ArrayList;

/**
 *
 * @author alumno2
 */
public class Serializar {
    
     
    public static void main(String[] args) {
        
        // Ejemplos
        Vehiculo v1 = new Vehiculo(1, "FEAT", "5151353E");
        Vehiculo v2 = new Vehiculo(2, "SETA", "6826842Q");
        Vehiculo v3 = new Vehiculo(3, "MERCEDEZ", "13151351A");
        
        ArrayList<Vehiculo> lista = new ArrayList();
        lista.add(v1);
        lista.add(v2);
        lista.add(v3);
        // END Ejemplos
        
        // Objetos de interacción con el archivo
        Codificador codificador = new Codificador();
        GestorFicheros ficheros = new GestorFicheros("vehiculo.txt");
        
        // Codificamos la lista en un string, y lo escribimos en el fichero
        String coded = codificador.codificar(lista);
        ficheros.escribirFichero(coded);
        
        // Leemos el fichero, y metemos su contenido en una string
        String objetosSerializados = ficheros.leerFichero();
        
        // Descodificamos la string, y obtenemos la lista de nuevo
        ArrayList<Vehiculo> objetos = codificador.descodificar(objetosSerializados);
        
        // Representamos la lista para comprobar que los objetos están
        // utilizables
        System.out.println("ID\tMARCA\tMODELO");
        for(Vehiculo p : objetos){
            System.out.println(
                    p.getId()+"\t"+p.getMarca()+"\t"+p.getModelo()
            );
        }
    
    }
    
}
