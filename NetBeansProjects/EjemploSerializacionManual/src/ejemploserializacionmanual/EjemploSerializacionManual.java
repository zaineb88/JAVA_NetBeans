/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploserializacionmanual;

import java.util.ArrayList;

/**
 *
 * @author profesoraula
 */
public class EjemploSerializacionManual {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Ejemplos
        Persona p1 = new Persona("Paco Gutiérrez", 40, "5151353E");
        Persona p2 = new Persona("María Molina", 35, "6826842Q");
        Persona p3 = new Persona("Elisa Alo", 36, "13151351A");
        
        ArrayList<Persona> lista = new ArrayList();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        // END Ejemplos
        
        // Objetos de interacción con el archivo
        Codificador codificador = new Codificador();
        GestorFicheros ficheros = new GestorFicheros("objetos.txt");
        
        // Codificamos la lista en un string, y lo escribimos en el fichero
        String coded = codificador.codificar(lista);
        ficheros.escribirFichero(coded);
        
        // Leemos el fichero, y metemos su contenido en una string
        String objetosSerializados = ficheros.leerFichero();
        
        // Descodificamos la string, y obtenemos la lista de nuevo
        ArrayList<Persona> objetos = codificador.descodificar(objetosSerializados);
        
        // Representamos la lista para comprobar que los objetos están
        // utilizables
        System.out.println("DNI\t\tNOMBRE\t\tEDAD");
        for(Persona p : objetos){
            System.out.println(
                    p.getDni()+"\t"+p.getNombre()+"\t"+p.getEdad()
            );
        }
    
    }
    
}
