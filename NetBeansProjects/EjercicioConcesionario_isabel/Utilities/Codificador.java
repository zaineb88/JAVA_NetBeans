/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Entities.Vehiculo;
import Entities.Coche;
import Entities.Camion;
import Entities.Moto;
import java.util.ArrayList;

/**
 *
 * @author profesoraula
 */
public class Codificador {
    
    final String FIELD_SEPARATOR = "###";
    final String OBJECT_SEPARATOR = "&&&";
    
    
    public String codificar(ArrayList<Vehiculo> lista){
        
        StringBuilder sb = new StringBuilder();
        for(Vehiculo v : lista){
            if(v instanceof Coche){
                Coche c = (Coche) v;
                sb.append("coche")
                  .append(FIELD_SEPARATOR)
                  .append(c.getId())
                  .append(FIELD_SEPARATOR)
                  .append(c.getMarca())
                  .append(FIELD_SEPARATOR)
                  .append(c.getModelo())
                  .append(FIELD_SEPARATOR)
                  .append(c.getPrecio())
                  .append(FIELD_SEPARATOR)
                  .append(c.getKilometraje())
                  .append(FIELD_SEPARATOR)
                  .append(c.isEsSegunda())
                  .append(OBJECT_SEPARATOR);
                          
            }else if(v instanceof Camion){
                Camion c = (Camion) v;
                sb.append("camion")
                  .append(FIELD_SEPARATOR)
                  .append(c.getId())
                  .append(FIELD_SEPARATOR)
                  .append(c.getMarca())
                  .append(FIELD_SEPARATOR)
                  .append(c.getModelo())
                  .append(FIELD_SEPARATOR)
                  .append(c.getCarga())
                  .append(FIELD_SEPARATOR)
                  .append(c.getPrecio())
                  .append(OBJECT_SEPARATOR);
            }else if(v instanceof Moto){
                Moto m = (Moto) v;
                sb.append("moto")
                  .append(FIELD_SEPARATOR)
                  .append(m.getId())
                  .append(FIELD_SEPARATOR)
                  .append(m.getMarca())
                  .append(FIELD_SEPARATOR)
                  .append(m.getModelo())
                  .append(FIELD_SEPARATOR)
                  .append(m.getCilindrada())
                  .append(FIELD_SEPARATOR)
                  .append(m.getPrecio())
                  .append(FIELD_SEPARATOR)
                  .append(m.getTipo())
                  .append(OBJECT_SEPARATOR);
                        
            }
        }
        
        return sb.toString();
    }
    
    public ArrayList<Vehiculo> descodificar(String s){
        
         ArrayList<Vehiculo> lista = new ArrayList();
         String[]objetos = s.split(OBJECT_SEPARATOR);
         for(String obj : objetos){
             String[]vars = obj.split(FIELD_SEPARATOR);
             switch(vars[0]){
                 case "coche":
                     lista.add(
                       new Coche(
                         Integer.valueOf(vars[5]), 
                         vars[2], 
                         vars[3], 
                         Float.valueOf(vars[4]),
                         Boolean.valueOf(vars[6]), 
                         Integer.valueOf(vars[1])
                       )
                     );
                     
                     break;
                     
                 case "camion":
                     lista.add(
                       new Camion(
                         Integer.valueOf(vars[4]),
                         vars[2],
                         vars[3],
                         Float.valueOf(vars[5]),
                         Integer.valueOf(vars[1])
                       )      
                     );
                     break;
                 case "moto":
                     lista.add(
                       new Moto(
                         Integer.valueOf(vars[6]),
                         vars[5],
                         vars[2],
                         vars[3],
                         Float.valueOf(vars[4]),
                         Integer.valueOf(vars[1])      
                       )      
                     );
                     break;
             }
         }
         return lista;
    }
    
}
