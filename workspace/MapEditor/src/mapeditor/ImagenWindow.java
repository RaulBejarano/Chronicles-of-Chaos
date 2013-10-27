package mapeditor;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class ImagenWindow extends javax.swing.JFrame {

    int filas, columnas;
    ArrayList<Imagen> objetos;
    MainWindow parent;

    public ImagenWindow(int filas, int columnas, MainWindow parent) {
        this.filas = filas;
        this.columnas = columnas;
        this.parent = parent;
        this.objetos = parent.panel.getImagenes();
        construir();

    }
    
    public ImagenWindow(int filas, int columnas,int fila, int columna, MainWindow parent) {
        this.filas = filas;
        this.columnas = columnas;
        this.parent = parent;
        this.objetos = parent.panel.getImagenes();
        construir();
        tFila.setText(fila+"");
        tColumna.setText(columna+"");
    }

    private void construir() {
        initComponents();
        tmaxfilas.setText("/" + filas);
        tmaxcolumnas.setText("/" + columnas);


        DefaultListModel model = new DefaultListModel();
        model.addElement("agua1");
        model.addElement("agua2");
        model.addElement("agua3");
        model.addElement("agua4");
        model.addElement("agua5");
        model.addElement("arbol1");
        model.addElement("arbol2");
        model.addElement("arbol3");
        model.addElement("arbol4");
        model.addElement("arbol5");
        model.addElement("arbol6");
        model.addElement("arbol7");
        model.addElement("arbol8");
        model.addElement("arbol9");
        model.addElement("arbol10");
        model.addElement("arbol11");
        model.addElement("arbol12");
        model.addElement("arbol13");
        model.addElement("arbol14");
        model.addElement("arbol15");
        model.addElement("arbol16");
        model.addElement("arbol17");
        model.addElement("arbol18");
        model.addElement("arbol19");
        model.addElement("arbol20");
        model.addElement("barracas1");
        model.addElement("barracas2");
        model.addElement("barracas3");
        model.addElement("cabana1");
        model.addElement("cabana2");
        model.addElement("cantina1");
        model.addElement("cantina2");
        model.addElement("cantina3");
        model.addElement("cantina4");
        model.addElement("cantina5");
        model.addElement("casa1");
        model.addElement("casa2");
        model.addElement("casa3");
        model.addElement("casa4");
        model.addElement("casa5");
        model.addElement("cason1");
        model.addElement("cason2");
        model.addElement("cason3");
        model.addElement("iglesia1");
        model.addElement("iglesia2");
        model.addElement("iglesia3");
        model.addElement("iglesia4");
        model.addElement("puerta1");
        model.addElement("puerta2");
        model.addElement("muralla1");
        model.addElement("muralla2");
        model.addElement("muralla3");
        model.addElement("muralla4");
        model.addElement("muralla5");
        model.addElement("muralla6");
        model.addElement("murallab1");
        model.addElement("torre1");
        model.addElement("taberna1");
        model.addElement("taberna2");
        model.addElement("taberna3");
        model.addElement("valla1");
        model.addElement("valla2");
        model.addElement("valla3");
        model.addElement("valla4");
        model.addElement("puente1");
        model.addElement("puente2");
        model.addElement("puente3");
        model.addElement("puente4");
        model.addElement("puente5");
        model.addElement("puente6");


        lista.setModel(model);
        lista.setSelectedIndex(0);
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
        lblDimensiones = new javax.swing.JLabel();

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

        lblDimensiones.setText("0:0");

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
                            .addComponent(tmaxfilas)))
                    .addComponent(lblDimensiones))
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
                        .addGap(2, 2, 2)
                        .addComponent(lblDimensiones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            Imagen img = new Imagen((String) lista.getSelectedValue(), Integer.parseInt(tFila.getText()), Integer.parseInt(tColumna.getText()));
            objetos.add(img);
            parent.panel.ordenarImagenesY();
            parent.repaint();
        }
    } catch (Exception e) {
        tFila.setBackground(Color.yellow);
        tColumna.setBackground(Color.yellow);
    }

}//GEN-LAST:event_jButton1ActionPerformed

private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
    ImageIcon img =new ImageIcon(getClass().getResource((String) lista.getSelectedValue()+".png"));
    labelImagen.setIcon(img);
    lblDimensiones.setText(img.getIconWidth()/32 +":"+img.getIconHeight()/32);
}//GEN-LAST:event_listaValueChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel lblDimensiones;
    private javax.swing.JList lista;
    private javax.swing.JTextField tColumna;
    private javax.swing.JTextField tFila;
    private javax.swing.JLabel tmaxcolumnas;
    private javax.swing.JLabel tmaxfilas;
    // End of variables declaration//GEN-END:variables
}
