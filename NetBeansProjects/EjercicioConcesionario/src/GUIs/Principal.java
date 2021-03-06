/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Entities.*;
import Utilities.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author profesoraula
 */
public class Principal extends javax.swing.JFrame {

    GestorFicheros ficheros = new GestorFicheros("objetos.txt");
    Codificador codificador = new Codificador();
    int maximoId = 0;
    
    public Principal() {
        initComponents();
        actualizar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCoches = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCamiones = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMotos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de concesionario");

        tabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabsMousePressed(evt);
            }
        });

        tablaCoches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCoches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaCochesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCoches);

        tabs.addTab("Coches", jScrollPane1);

        tablaCamiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCamiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaCamionesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCamiones);

        tabs.addTab("Camiones", jScrollPane2);

        tablaMotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaMotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMotosMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaMotos);

        tabs.addTab("Motos", jScrollPane3);

        jButton1.setText("Crear vehículo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        modificar.setText("Modificar vehículo");
        modificar.setEnabled(false);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        borrar.setText("Borrar vehículo");
        borrar.setEnabled(false);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed

        int id=-1;
        if(tabs.getSelectedIndex()==0){
            id = (int) tablaCoches.getValueAt(tablaCoches.getSelectedRow(), 0);
        }else if(tabs.getSelectedIndex()==1){
              id = (int) tablaCamiones.getValueAt(tablaCamiones.getSelectedRow(), 0);
        }else if(tabs.getSelectedIndex()==2){
            id = (int) tablaMotos.getValueAt(tablaMotos.getSelectedRow(), 0);
        }
        
        String s = ficheros.leerFichero();
        ArrayList<Vehiculo> data = codificador.descodificar(s);
        for(int i=0;i<data.size();i++){
            if(data.get(i).getId() == id){
               data.remove(i);
            }
        }
        ficheros.escribirFichero(codificador.codificar(data));
        actualizar();
    }//GEN-LAST:event_borrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        VehiculoDiag diag = new VehiculoDiag(this,true);
        diag.setVisible(true);
        if(diag.v != null){
            diag.v.setId(++maximoId);
            
            String s = ficheros.leerFichero();
            ArrayList<Vehiculo> data = null;
            if(s != null){
                data = codificador.descodificar(s);
            }else{
                data = new ArrayList();
            }
            data.add(diag.v);
            String coded = codificador.codificar(data);
            ficheros.escribirFichero(coded);
            actualizar();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaCochesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCochesMousePressed
        
        if(tablaCoches.getSelectedRow() != -1){
            modificar.setEnabled(true);
            borrar.setEnabled(true);
        }else{
            modificar.setEnabled(false);
            borrar.setEnabled(false);
        }
        
        
        
    }//GEN-LAST:event_tablaCochesMousePressed

    private void tablaCamionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCamionesMousePressed
      if(tablaCamiones.getSelectedRow() != -1){
            modificar.setEnabled(true);
            borrar.setEnabled(true);
        }else{
            modificar.setEnabled(false);
            borrar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaCamionesMousePressed

    private void tabsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMousePressed
            modificar.setEnabled(false);
            borrar.setEnabled(false);
     
    }//GEN-LAST:event_tabsMousePressed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        
        int id=-1;
        Vehiculo modificar = null;
        if(tabs.getSelectedIndex()==0){
            id = (int) tablaCoches.getValueAt(tablaCoches.getSelectedRow(), 0);
        }else if(tabs.getSelectedIndex()==1){
              id = (int) tablaCamiones.getValueAt(tablaCamiones.getSelectedRow(), 0);
        }else if(tabs.getSelectedIndex()==2){
              id = (int) tablaMotos.getValueAt(tablaMotos.getSelectedRow(), 0);
        }
        ArrayList<Vehiculo>data = codificador.descodificar(ficheros.leerFichero());
            for(Vehiculo v : data){
                if(v.getId()==id){
                    modificar = v;
                    break;
                }
            }
            
        VehiculoDiag diag = new VehiculoDiag(this, true, modificar);
        diag.setVisible(true);
        int pos = -1;
        for(int i=0;i<data.size();i++){
            Vehiculo v = data.get(i);
            if(v.getId() == modificar.getId()){
                pos = i;
                break;
            }
        }
        data.set(pos, diag.v);
        ficheros.escribirFichero(codificador.codificar(data));
        actualizar();
        
    }//GEN-LAST:event_modificarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaMotosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMotosMousePressed
        if(tablaMotos.getSelectedRow() != -1){
            modificar.setEnabled(true);
            borrar.setEnabled(true);
        }else{
            modificar.setEnabled(false);
            borrar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaMotosMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tablaCamiones;
    private javax.swing.JTable tablaCoches;
    private javax.swing.JTable tablaMotos;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables

  public void actualizar(){
      
      // Definición de la tabla
      DefaultTableModel modeloCoches = new DefaultTableModel();
      DefaultTableModel modeloCamiones = new DefaultTableModel();
      DefaultTableModel modeloMotos = new DefaultTableModel();
      modeloCoches.setColumnIdentifiers(
              new Object[]{"ID", "Marca", "Modelo", "Precio", "Kilometraje", "Segunda mano"});
      modeloCamiones.setColumnIdentifiers(
              new Object[]{"ID", "Marca", "Modelo", "Precio", "Carga"});
      modeloMotos.setColumnIdentifiers(
              new Object[]{"ID", "Marca", "Modelo", "Precio", "Cilindrada", "Tipo"});
      tablaCoches.setModel(modeloCoches);
      tablaCamiones.setModel(modeloCamiones);
      tablaMotos.setModel(modeloMotos);
      
      // Obtención de la información
      String data = ficheros.leerFichero();
      if(data != null){
      ArrayList<Vehiculo> listaVehiculos = codificador.descodificar(data);
      
      
      for(Vehiculo v : listaVehiculos){
          if(v.getId() > maximoId){
              maximoId = v.getId();
          }
      }      
      
      // Representación de la misma
      for(Vehiculo v : listaVehiculos){
          if(v instanceof Coche){
              Coche c = (Coche)v;
              modeloCoches.addRow(
                      new Object[]{
                          c.getId(),
                          c.getMarca(),
                          c.getModelo(),
                          c.getPrecio(),
                          c.getKilometraje(),
                          c.isEsSegunda()
                      });
          }else if(v instanceof Camion){
              Camion c = (Camion)v;
              modeloCamiones.addRow(
                        new Object[]{
                            c.getId(),
                            c.getMarca(),
                            c.getModelo(),
                            c.getPrecio(),
                            c.getCarga()
                        }
              );
          }
          else if(v instanceof Moto){
              Moto m = (Moto) v;
              modeloMotos.addRow(
                        new Object[]{
                            m.getId(),
                            m.getMarca(),
                            m.getModelo(),
                            m.getPrecio(),
                            m.getCilindrada(),
                            m.getTipo()
                        }
              );
          }
      }
    }
  }


}
