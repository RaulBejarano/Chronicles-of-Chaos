package chronicles_zahin.pkg;

public class Nexo {

	private String id, enlace;
	private int posX, posY;
	private final int ancho=48, alto=48;
	private int direccion;
	
	public Nexo (String id, int posX, int posY, int direccion, String enlace){
		this.id=id;
		this.posX=posX;
		this.posY=posY;
		this.enlace=enlace;
		this.setDireccion(direccion);
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
}
