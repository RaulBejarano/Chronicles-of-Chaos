/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

/**
 *
 * @author raul
 */
public class Nexo extends Imagen{
    private int direccion;
    
    public Nexo(String img, int fila, int columna, int direccion){
        super(img, fila, columna);
        this.direccion=direccion;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    
    
}
