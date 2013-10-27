package chronicles_zahin.pkg;

import android.graphics.Bitmap;
import android.view.Display;
import android.view.Surface;

public class ArmaSprite {
	private Bitmap arma;
	private int posX, posY, vida;
	private int fila;
	private int currentFrame, columnas;
	private int filas;
	
	public ArmaSprite(Bitmap arma, Display display, PEstatico p, int vida) {
		this.arma = arma;
		this.setVida(vida);
		this.columnas = arma.getWidth() / 48;
		this.filas=arma.getHeight()/48;
		
		int posPersonajeX = display.getWidth() / 2 - p.getAncho() / 2;
		int posPersonajeY;
		// Posicion del personaje en la pantalla
		if(display.getRotation()==Surface.ROTATION_0||display.getRotation()==Surface.ROTATION_180){
			posPersonajeY = display.getHeight() / 2 - p.getAlto() / 2 - 160;
		}else{
			posPersonajeY = display.getHeight() / 2;
		}
		
		switch (p.getDireccion()) {
		case 1:
		case 2:
		case 3:
			posX = posPersonajeX;
			posY = posPersonajeY - p.getAlto() + 30;
			fila = 0;
			break;
		case 4:
			posX = posPersonajeX - p.getAncho() + 20;
			posY = posPersonajeY;
			fila = 1;
			break;
		case 5:
			posX = posPersonajeX+ p.getAncho() - 25;
			posY = posPersonajeY;
			fila = 2;
			break;
		case 6:
		case 7:
		case 8:
		default:
			posX = posPersonajeX;
			posY = posPersonajeY + p.getAlto() - 20;
			fila = 3;
			
				
		}

		
	}

	public Bitmap getCurrentBitmap() {
		if (--vida < 1) {
			return null;
		}		
		currentFrame = ++currentFrame % columnas;		
		int srcX = currentFrame * arma.getWidth() / columnas;
		int srcY = fila * arma.getHeight() / filas;
		Bitmap b = Bitmap.createBitmap(arma, srcX, srcY, arma.getWidth() / columnas,
				arma.getHeight() / filas);
		return b;		
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

}
