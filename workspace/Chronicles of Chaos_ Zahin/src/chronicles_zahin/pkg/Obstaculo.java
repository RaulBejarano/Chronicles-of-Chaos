package chronicles_zahin.pkg;



public class Obstaculo {
	
	private int posX, posY, ancho, alto;
	
	public Obstaculo (int posX, int posY, int ancho, int alto){
		this.setPosX(posX);
		this.setPosY(posY);
		this.ancho=ancho;
		this.alto=alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
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


	
}
