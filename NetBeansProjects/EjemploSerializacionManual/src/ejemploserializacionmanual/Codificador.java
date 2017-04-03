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
public class Codificador {
    
    final String FIELD_SEPARATOR = "---";
    final String OBJECT_SEPARATOR = "###";
    
    
    public String codificar(ArrayList<Persona> lista){
        
        StringBuilder sb = new StringBuilder();
        for(Persona p : lista){
            sb.append(p.getNombre())
              .append(FIELD_SEPARATOR)
              .append(p.getEdad())
              .append(FIELD_SEPARATOR)
              .append(p.getDni())
              .append(OBJECT_SEPARATOR);
        }
        return sb.toString();
    }
    
    public ArrayList<Persona> descodificar(String s){
        
        ArrayList<Persona> lista = new ArrayList();
        
        String[]objetos = s.split(OBJECT_SEPARATOR);
        for(String objeto : objetos){
            String[]vars = objeto.split(FIELD_SEPARATOR);
            lista.add(
                new Persona(
                   vars[0],
                   Integer.valueOf(vars[1]),
                   vars[2]
                )
            );
        }
        return lista;
    }
    
}
