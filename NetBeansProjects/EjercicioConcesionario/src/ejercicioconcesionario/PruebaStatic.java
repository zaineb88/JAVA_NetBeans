/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioconcesionario;

/**
 *
 * @author profesoraula
 */
class Obj{
    int x;
    static int y;
}

public class PruebaStatic {
 
    int[]array;
    
    public static void main(String[]args){
        
        // Instancia normal, requerida para acceder a la 
        // variable de clase "array".
        PruebaStatic prueba = new PruebaStatic();
        prueba.array = new int[5];
        
        // Otra forma de hacerlo, es obviando la referencia
        // inicial.
        new PruebaStatic().array = new int[5];

        /* Prueba para explicar el static: instanciamos dos
           objetos de tipo "Obj" con dos variables:
            - x, normal
            - y, estática
        
           Vamos a probar a cambiar sus valores para ver cómo
           evolucionan, y demostrar cómo los miembros estáticos
           de una clase, pertenecen a la clase, y no al objeto.
        */
        Obj o1 = new Obj();
        Obj o2 = new Obj();
        
        o1.x = 5;
        o2.x = 3;
        
        o1.y = 4;
        o2.y = 7;
        
        System.out.println("o1.x: "+o1.x); // 5
        System.out.println("o1.y: "+o1.y); // 7
        System.out.println("o2.x: "+o2.x); // 3
        System.out.println("o2.y: "+o2.y); // 7
        
        // El hecho de que en o1.y salga 7 y no 4, es porque
        // ambos objetos acceden a la MISMA variable, y o2
        // sustituye el valor anterior.
        
        // Adicionalmente, cabe destacar que la forma buena
        // de acceder a los miembros estáticos, es a través
        // del nombre de la clase:
        
        Obj.y = 5;
        
    }
    
}
