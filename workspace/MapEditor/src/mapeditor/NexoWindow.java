package mapeditor;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class NexoWindow extends javax.swing.JFrame {

    int filas, columnas;
    ArrayList<Nexo> nexos;
    MainWindow parent;

    public NexoWindow(int filas, int columnas, MainWindow parent) {
        this.filas = filas;
        this.columnas = columnas;
        this.parent = parent;
        this.nexos = parent.panel.getNexos();
        construir();

    }
    
    public NexoWindow(int filas, int columnas,int fila, int columna, MainWindow parent) {
        this.filas = filas;
        this.columnas = columnas;
        this.parent = parent;
        this.nexos = parent.panel.getNexos();
        construir();
        tFila.setText(fila+"");
        tColumna.setText(columna+"");
    }

    private void construir() {
        initComponents();
        tmaxfilas.setText("/" + filas);
        tmaxcolumnas.setText("/" + columnas);


        DefaultListModel model = new DefaultListModel();
        model.addElement("nexoUp");
        model.addElement("nexoRight");
        model.addElement("nexoDown");
        model.addElement("nexoLeft");        
        
        lista.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tFila = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tColumna = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        labelImagen = new javax.swing.JLabel();
        tmaxfilas = new javax.swing.JLabel();
        tmaxcolumnas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Fila:");

        jLabel2.setText("Columna:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        labelImagen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tmaxfilas.setText("/1000");

        tmaxcolumnas.setText("/1000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tFila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tColumna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tmaxcolumnas)
                            .addComponent(tmaxfilas))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tmaxfilas))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tmaxcolumnas))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        if (Integer.parseInt(tFila.getText()) < filas && Integer.parseInt(tColumna.getText()) < columnas) {
            Nexo nexo = new Nexo((String) lista.getSelectedValue(), Integer.parseInt(tFila.getText()), Integer.parseInt(tColumna.getText()),lista.getSelectedIndex()+1);
            nexos.add(nexo);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JList lista;
    private javax.swing.JTextField tColumna;
    private javax.swing.JTextField tFila;
    private javax.swing.JLabel tmaxcolumnas;
    private javax.swing.JLabel tmaxfilas;
    // End of variables declaration//GEN-END:variables
}
