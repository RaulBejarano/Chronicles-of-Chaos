/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FondoWindow.java
 *
 * Created on 26-dic-2011, 22:43:18
 */
package mapeditor;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author raul
 */
public class FondoWindow extends javax.swing.JFrame {

    int filas, columnas;
    ArrayList<Imagen> objetos;
    MainWindow parent;

    public FondoWindow(int filas, int columnas, MainWindow parent) {
        this.filas = filas;
        this.columnas = columnas;
        this.parent = parent;
        this.objetos = parent.panel.getFondo();
        initComponents();


        DefaultListModel model = new DefaultListModel();
        
        model.addElement("hierba1");
        model.addElement("hierba2");
        model.addElement("hierba3");
        model.addElement("desierto");
        model.addElement("arena1");
        model.addElement("madera1");
        model.addElement("madera2");
        model.addElement("madera3");
        model.addElement("adoquines1");
        model.addElement("adoquines2");
        model.addElement("adoquines3");
        model.addElement("adoquines4");
        model.addElement("calle1a");
        model.addElement("calle1b");
        model.addElement("calle1curva1");
        model.addElement("calle1curva2");
        model.addElement("calle1curva3");
        model.addElement("calle1curva4");
        model.addElement("calle1sumidero");
        model.addElement("calle2a");
        model.addElement("calle2b");
        model.addElement("calle2curva1");
        model.addElement("calle2curva2");
        model.addElement("calle2curva3");
        model.addElement("calle2curva4");
        
        lista.setModel(model);
        lista.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        labelImagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tFila = new javax.swing.JTextField();
        tColumna = new javax.swing.JTextField();
        tAncho = new javax.swing.JTextField();
        tAlto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jLabel2.setText("Fila:");

        jLabel3.setText("Columna:");

        jLabel4.setText("Filas Ancho:");

        jLabel5.setText("Filas Alto:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tAncho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tColumna, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tFila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                            .addComponent(tAlto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                    .addComponent(labelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tAlto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        if (Integer.parseInt(tFila.getText()) < filas && Integer.parseInt(tColumna.getText()) < columnas) {
            Imagen img;
            for (int i = Integer.parseInt(tFila.getText()); i < Integer.parseInt(tFila.getText()) + Integer.parseInt(tAlto.getText()); i++) {
                for (int j = Integer.parseInt(tColumna.getText()); j < Integer.parseInt(tColumna.getText()) + Integer.parseInt(tAncho.getText()); j++) {
                    img = new Imagen((String) lista.getSelectedValue(), i, j);
                    objetos.add(img);
                }
            }
            parent.repaint();
        }
    } catch (Exception e) {
        tFila.setBackground(Color.yellow);
        tColumna.setBackground(Color.yellow);
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
labelImagen.setIcon(new ImageIcon(getClass().getResource((String) lista.getSelectedValue()+".png")));
}//GEN-LAST:event_listaValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JList lista;
    private javax.swing.JTextField tAlto;
    private javax.swing.JTextField tAncho;
    private javax.swing.JTextField tColumna;
    private javax.swing.JTextField tFila;
    // End of variables declaration//GEN-END:variables
}
