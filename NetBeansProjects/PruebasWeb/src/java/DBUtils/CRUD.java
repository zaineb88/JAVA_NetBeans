/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.util.ArrayList;

/**
 *
 * @author profesoraula
 */
public interface CRUD {
    
    void create(Object o);
    Object read(int id);
    ArrayList readAll(int page);
    void update(Object o);
    void delete(int id);
    
}
