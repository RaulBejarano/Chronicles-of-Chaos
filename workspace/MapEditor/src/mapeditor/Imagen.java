/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;


/**
 *
 * @author eduardo
 */
public class Imagen {
    String img;
    int fila, columna;
    int ancho, alto;
    
    public Imagen (String b, int fila, int columna){
        this.img=b;
        this.fila=fila;
        this.columna=columna;
    }
    
        
    public Imagen (String b, int fila, int columna, int ancho, int alto){
        this.img=b;
        this.fila=fila;
        this.columna=columna;
        
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

   
}
