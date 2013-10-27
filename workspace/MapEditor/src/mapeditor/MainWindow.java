package mapeditor;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow extends javax.swing.JFrame {

    int filas;
    int columnas;
    MyPanel panel;

    /** Creates new form MainWindow */
    public MainWindow(int x, int y) {
        this.filas = x;
        this.columnas = y;
        initComponents();
        panel = new MyPanel(x, y);

        jScrollPane1.setViewportView(panel);
        panel.setPreferredSize(new Dimension(y * 32, x * 32));

        MouseListener ml = new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    abrirImagenWindow(e.getY() / 32, e.getX() / 32);
                }
            }
        };
        panel.addMouseListener(ml);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemAbrir = new javax.swing.JMenuItem();
        itemExportar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemAñadir = new javax.swing.JMenuItem();
        itemAñadirSuelo = new javax.swing.JMenuItem();
        itemAñadirNexo = new javax.swing.JMenuItem();
        itemBorrarObjeto = new javax.swing.JMenuItem();
        itemBorrarSuelo = new javax.swing.JMenuItem();
        itemBorrarNexo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        itemNuevo.setText("Nuevo");
        itemNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemNuevoMouseReleased(evt);
            }
        });
        jMenu1.add(itemNuevo);

        itemAbrir.setText("Abrir");
        itemAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemAbrirMouseReleased(evt);
            }
        });
        jMenu1.add(itemAbrir);

        itemExportar.setText("Exportar");
        itemExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemExportarMouseReleased(evt);
            }
        });
        jMenu1.add(itemExportar);

        itemSalir.setText("Salir");
        itemSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemSalirMouseReleased(evt);
            }
        });
        jMenu1.add(itemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        itemAñadir.setText("Añadir Objeto");
        itemAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemAñadirMouseReleased(evt);
            }
        });
        jMenu2.add(itemAñadir);

        itemAñadirSuelo.setText("Añadir Suelo");
        itemAñadirSuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemAñadirSueloMouseReleased(evt);
            }
        });
        jMenu2.add(itemAñadirSuelo);

        itemAñadirNexo.setText("Añadir Nexo");
        itemAñadirNexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemAñadirNexoMouseReleased(evt);
            }
        });
        jMenu2.add(itemAñadirNexo);

        itemBorrarObjeto.setText("Borrar Objeto");
        itemBorrarObjeto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemBorrarObjetoMouseReleased(evt);
            }
        });
        jMenu2.add(itemBorrarObjeto);

        itemBorrarSuelo.setText("Borrar Suelo");
        itemBorrarSuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemBorrarSueloMouseReleased(evt);
            }
        });
        jMenu2.add(itemBorrarSuelo);

        itemBorrarNexo.setText("Borrar Nexo");
        itemBorrarNexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemBorrarNexoMouseReleased(evt);
            }
        });
        jMenu2.add(itemBorrarNexo);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void itemSalirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemSalirMouseReleased
    this.dispose();
}//GEN-LAST:event_itemSalirMouseReleased

private void itemNuevoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemNuevoMouseReleased
}//GEN-LAST:event_itemNuevoMouseReleased

private void itemAbrirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemAbrirMouseReleased
// TODO add your handling code here:
}//GEN-LAST:event_itemAbrirMouseReleased

private void itemExportarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemExportarMouseReleased

    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("PNG", "png"));
    if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File file;
        BufferedWriter bw = null;
        String nombreMapa;
        
        //Exportar Imagen        
        if (!chooser.getSelectedFile().getPath().endsWith(".png")) {
            file = new File(chooser.getSelectedFile().getPath() + ".png");
        } else {
            file = new File(chooser.getSelectedFile().getPath());
        }
        nombreMapa = file.getName().substring(0, file.getName().length()-4);
        panel.exportarPanel(file);
        //Exportar sql
        try {

            if (!chooser.getSelectedFile().getPath().endsWith(".png")) {
                file = new File(chooser.getSelectedFile().getPath() + ".sql");
            } else {
                String aux = chooser.getSelectedFile().getPath();
                aux = aux.substring(0, aux.length() - 4);
                aux = aux + ".sql";
                file = new File(aux);
            }

            bw = new BufferedWriter(new FileWriter(file));
            //Obstaculos
            ArrayList<Imagen> obj = panel.getImagenes();
            Imagen obs;
            ImageIcon im;
            bw.write("INSERT INTO MAPA (imagen) VALUES ('" + nombreMapa + "');");
            bw.write("\n");
            for (int i = 0; i < obj.size(); i++) {
                obs = obj.get(i);
                im = new ImageIcon(getClass().getResource(obs.getImg()+".png"));
                bw.write("INSERT INTO OBSTACULO (posx, posy, ancho, alto, mapa) VALUES (" + obs.getColumna()*48 + ", " + obs.getFila()*48 + ", " + im.getIconWidth()*48/32  + ", " + im.getIconHeight()*48/32  + ", (SELECT id FROM MAPA WHERE imagen='" + nombreMapa + "'));");
                bw.write("\n");
            }

            //Nexos
            String id, enlace;
            ArrayList<Nexo> obj2 = panel.getNexos();
            Nexo obs2;
            for (int i = 0; i < obj2.size(); i++) {
                obs2 = obj2.get(i);
                id = JOptionPane.showInputDialog("Introduce codigo de nexo en la posición:\n"
                        + "fila: " + obs2.getFila() + "\n"
                        + "columna: " + obs2.getColumna());

                enlace = JOptionPane.showInputDialog("Introduce codigo de enlace");

                bw.write("INSERT INTO NEXO (id, mapa, posx, posy, direccion, enlace) VALUES ('" + id + "', (SELECT id FROM MAPA WHERE imagen='" + nombreMapa + "'), " + obs2.getColumna()*48 + ", " + obs2.getFila()*48 + ", "+obs2.getDireccion()+", '" + enlace + "');");
                bw.write("\n");
            }

            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

}//GEN-LAST:event_itemExportarMouseReleased

private void itemAñadirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemAñadirMouseReleased
    ImagenWindow ventana = new ImagenWindow(filas, columnas, this);
    ventana.setVisible(true);
}//GEN-LAST:event_itemAñadirMouseReleased

private void itemAñadirSueloMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemAñadirSueloMouseReleased
    FondoWindow ventana = new FondoWindow(filas, columnas, this);
    ventana.setVisible(true);
}//GEN-LAST:event_itemAñadirSueloMouseReleased

private void itemBorrarObjetoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemBorrarObjetoMouseReleased
    try {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Fila: "));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Columna: "));
        for (int i = 0; i < panel.getImagenes().size(); i++) {
            if (panel.getImagenes().get(i).getColumna() == columna && panel.getImagenes().get(i).getFila() == fila) {
                panel.getImagenes().remove(i);
            }
        }
        panel.repaint();
    } catch (Exception e) {
    }
}//GEN-LAST:event_itemBorrarObjetoMouseReleased

private void itemBorrarSueloMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemBorrarSueloMouseReleased
    try {
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Fila: "));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Columna: "));
        for (int i = 0; i < panel.getFondo().size(); i++) {
            if (panel.getFondo().get(i).getColumna() == columna && panel.getFondo().get(i).getFila() == fila) {
                panel.getFondo().remove(i);
            }
        }
        panel.repaint();
    } catch (Exception e) {
    }
}//GEN-LAST:event_itemBorrarSueloMouseReleased

private void itemBorrarNexoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemBorrarNexoMouseReleased
// TODO add your handling code here:
}//GEN-LAST:event_itemBorrarNexoMouseReleased

private void itemAñadirNexoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemAñadirNexoMouseReleased
    NexoWindow ventana = new NexoWindow(filas, columnas, this);
    ventana.setVisible(true);
}//GEN-LAST:event_itemAñadirNexoMouseReleased

    private void abrirImagenWindow(int fila, int columna) {
        ImagenWindow ventana = new ImagenWindow(filas, columnas, fila, columna, this);
        ventana.setVisible(true);
    }

    private void abrirFondonWindow(int fila, int columna, int ancho, int alto) {
        ImagenWindow ventana = new ImagenWindow(filas, columnas, fila, columna, this);
        ventana.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemAñadir;
    private javax.swing.JMenuItem itemAñadirNexo;
    private javax.swing.JMenuItem itemAñadirSuelo;
    private javax.swing.JMenuItem itemBorrarNexo;
    private javax.swing.JMenuItem itemBorrarObjeto;
    private javax.swing.JMenuItem itemBorrarSuelo;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
