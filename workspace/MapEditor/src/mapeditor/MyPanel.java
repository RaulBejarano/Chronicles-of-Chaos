package mapeditor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    int filas, columnas;
    final int ancho = 32;
    ArrayList<Imagen> imagenes;
    ArrayList<Imagen> fondo;
    ArrayList<Nexo> nexos;

    public MyPanel(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        imagenes = new ArrayList<Imagen>(0);
        fondo = new ArrayList<Imagen>(0);
        nexos = new ArrayList<Nexo>(0);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        Imagen img;

        for (int i = 0; i < imagenes.size(); i++) {
            img = imagenes.get(i);
            if (imagenes.get(i).getImg().contains("agua")) {
                g.drawImage(new ImageIcon(getClass().getResource(img.getImg()+".png")).getImage(), img.getColumna() * ancho, img.getFila() * ancho, null);
            }
        }

        for (int i = 0; i < fondo.size(); i++) {
            img = fondo.get(i);
            g.drawImage(new ImageIcon(getClass().getResource(img.getImg()+".png")).getImage(), img.getColumna() * ancho, img.getFila() * ancho, null);
        }

        for (int i = 0; i < imagenes.size(); i++) {
            img = imagenes.get(i);
            if (!imagenes.get(i).getImg().contains("agua")) {
                g.drawImage(new ImageIcon(getClass().getResource(img.getImg()+".png")).getImage(), img.getColumna() * ancho, img.getFila() * ancho, null);
            }
        }

        for (int i = 0; i < nexos.size(); i++) {
            img = nexos.get(i);
            g.drawImage(new ImageIcon(getClass().getResource(img.getImg()+".png")).getImage(), img.getColumna() * ancho, img.getFila() * ancho, null);

        }

        g.setColor(Color.green);
        //lineas horizontales
        for (int i = 0; i <= filas * ancho; i += ancho) {
            g.drawLine(0, i, getWidth(), i);
            g.drawString(i / 32 + "", 2, i + 12);
        }
        //lineas verticales
        for (int i = 0; i <= columnas * ancho; i += ancho) {
            g.drawLine(i, 0, i, getHeight());
            g.drawString(i / 32 + "", i + 2, 12);
        }
    }

    public void insertarImagen(String nombre, int fila, int columna) {
        imagenes.add(new Imagen(nombre, fila, columna));
        repaint();
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public int getAncho() {
        return ancho;
    }

    public ArrayList<Imagen> getFondo() {
        return fondo;
    }

    public ArrayList<Nexo> getNexos() {
        return nexos;
    }

    public void ordenarImagenesY() {
        for (int i = 0; i < imagenes.size() - 1; i++) {
            if (imagenes.get(i).getFila() > imagenes.get(i + 1).getFila()) {
                Imagen imagen = imagenes.get(i);
                imagenes.set(i, imagenes.get(i + 1));
                imagenes.set(i + 1, imagen);
            }
        }
    }

    public void exportarPanel(File file) {
        RenderedImage rendImage = myCreateImage();
        // Write generated image to a file
        try {
            // Save as PNG

            ImageIO.write(rendImage, "png", file);

        } catch (IOException e) {
        }


    }

    private RenderedImage myCreateImage() {

        // Create a buffered image in which to draw
        BufferedImage bufferedImage = new BufferedImage(columnas * ancho, filas * ancho, BufferedImage.TYPE_INT_RGB);

        // Create a graphics contents on the buffered image
        Graphics2D g = bufferedImage.createGraphics();
        // Draw graphics
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());



        Imagen img;
        for (int i = 0; i < fondo.size(); i++) {
            img = fondo.get(i);
            g.drawImage(new ImageIcon(getClass().getResource(img.getImg()+".png")).getImage(), img.getColumna() * ancho, img.getFila() * ancho, null);
        }

        for (int i = 0; i < imagenes.size(); i++) {
            img = imagenes.get(i);
            g.drawImage(new ImageIcon(getClass().getResource(img.getImg()+".png")).getImage(), img.getColumna() * ancho, img.getFila() * ancho, null);

        }

        for (int i = 0; i < nexos.size(); i++) {
            img = nexos.get(i);
            g.drawImage(new ImageIcon(getClass().getResource(img.getImg()+".png")).getImage(), img.getColumna() * ancho, img.getFila() * ancho, null);
        }

        // Graphics context no longer needed so dispose it
        g.dispose();

        return bufferedImage;
    }
}
