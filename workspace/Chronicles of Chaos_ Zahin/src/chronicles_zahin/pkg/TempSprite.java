package chronicles_zahin.pkg;

import android.graphics.Bitmap;

public class TempSprite {
	private Bitmap imagen;
	private int posX, posY;
	private int vida;
	private int columnas;
	private int currentFrame;
	
	public TempSprite(Bitmap imagen, int posX, int posY, int vida){
		this.setImagen(imagen);
		this.setPosX(posX);
		this.setPosY(posY);
		this.setVida(vida);
		columnas=imagen.getWidth()/48;
	}

	public Bitmap getCurrentBitmap(){		
		if(--vida<1){
			return null;
		}
		System.out.println(currentFrame+":"+columnas);
		currentFrame = ++currentFrame % columnas;
		int srcX = currentFrame * imagen.getWidth()/columnas;
		Bitmap b = Bitmap.createBitmap(getImagen(), srcX, 0, imagen.getWidth()/columnas, imagen.getHeight());
		return b;		
	}
	
	
	public Bitmap getImagen() {
		return imagen;
	}

	public void setImagen(Bitmap imagen) {
		this.imagen = imagen;
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
}
