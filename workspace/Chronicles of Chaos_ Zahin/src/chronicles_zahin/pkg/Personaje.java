package chronicles_zahin.pkg;

import android.graphics.Bitmap;

public abstract class Personaje {
	private int id;
	private Bitmap imagen;
	private String nombre;
	protected int posX;
	protected int posY;
	private int vida;
	private int maxVida;
	protected Mapa mapa;
	
	private int currentFrame = 0;
	protected int direccion = 0;
	
	public Personaje(int id, Mapa mapa, Bitmap imagen, String nombre, int posX,
			int posY, int vida, int maxVida) {
		this.setId(id);
		this.setImagen(imagen);
		this.setNombre(nombre);
		this.setPosX(posX);
		this.setPosY(posY);
		this.setVida(vida);
		this.setMaxVida(maxVida);
		this.mapa=mapa;
	}

	abstract public void update();

	
	
	public Bitmap currentBitmap() {
		// 1=up-left, 2=up, 3=up-right 4=left ,5=right ,6=down-left, 7=down
		// ,8=down-right

		int fila = 0;
		switch (direccion) {
		case 1:
			fila = 3;
			break;
		case 2:
			fila = 3;
			break;
		case 3:
			fila = 3;
			break;
		case 4:
			fila = 1;
			break;
		case 5:
			fila = 2;
			break;
		case 6:
			fila = 0;
			break;
		case 7:
			fila = 0;
			break;
		case 8:
			fila = 0;
		default:
			fila = 0;
			direccion=7;
		}
		int srcX = currentFrame * getAncho();
		int srcY = fila * getAlto();
		Bitmap b = Bitmap.createBitmap(getImagen(), srcX, srcY, getAncho(),
				getAlto());

		return b;
	}

	public void doMovement(int direccion) {
		setDireccion(direccion);

		int nuevaX = -1;
		int nuevaY = -1;
		switch (direccion) {
		case 1:
			nuevaX = getPosX() - getAncho() / 3;
			nuevaY = getPosY() - getAlto() / 3;
			break;
		case 2:
			nuevaX = getPosX();
			nuevaY = getPosY() - getAncho() / 3;
			break;
		case 3:
			nuevaX = getPosX() + getAncho() / 3;
			nuevaY = getPosY() - getAncho() / 3;
			break;
		case 4:
			nuevaX = getPosX() - getAncho() / 3;
			nuevaY = getPosY();
			break;
		case 5:
			nuevaX = getPosX() + getAncho() / 3;
			nuevaY = getPosY();
			break;
		case 6:
			nuevaX = getPosX() - getAncho() / 3;
			nuevaY = getPosY() + getAlto() / 3;
			break;
		case 7:
			nuevaX = getPosX();
			nuevaY = getPosY() + getAlto() / 3;
			break;
		case 8:
			nuevaX = getPosX() + getAncho() / 3;
			nuevaY = getPosY() + getAlto() / 3;
			break;

		}
			
		if (nuevaX >= 0 && nuevaX < mapa.getWidth() - getAncho() * 2 / 3
				&& nuevaY >= -getAlto() * 2 / 3
				&& nuevaY < mapa.getHeight() - getAlto() * 2 / 3
				&& !isObstaculo(nuevaX, nuevaY)) {
			update();
		}

	}
	
	public boolean isObstaculo(int nuevaX, int nuevaY) {

		for (int i = 0; i < mapa.getObstaculo().size(); i++) {
			if (nuevaX > mapa.getObstaculo().get(i).getPosX()
					- getAncho()
					&& nuevaX < mapa.getObstaculo().get(i).getPosX()
							+ mapa.getObstaculo().get(i).getAncho()) {
				if (nuevaY > mapa.getObstaculo().get(i).getPosY()
						- getAlto()
						&& nuevaY < mapa.getObstaculo().get(i).getPosY()
								+ mapa.getObstaculo().get(i).getAlto()
								- getAlto() * 2 / 3) {
					return true;
					
				}
			}
		}
		return false;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bitmap getImagen() {
		return imagen;
	}

	public void setImagen(Bitmap imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setParado() {
		currentFrame = 1;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAncho() {
		return imagen.getWidth() / 3;
	}

	public int getAlto() {
		return imagen.getHeight() / 4;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	public int getMaxVida() {
		return maxVida;
	}

	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}

	public void setMapa(Mapa m){
		this.mapa=m;
	}
	
}
