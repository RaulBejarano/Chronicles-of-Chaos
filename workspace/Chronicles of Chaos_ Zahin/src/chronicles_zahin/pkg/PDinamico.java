package chronicles_zahin.pkg;

import android.graphics.Bitmap;

public class PDinamico extends Personaje {

	PEstatico estatico;
	private boolean enemigo;

	public PDinamico(int id, Mapa mapa, Bitmap imagen, String nombre, int posX,
			int posY, int vida, int maxVida, boolean enemigo, PEstatico estatico) {
		super(id, mapa, imagen, nombre, posX, posY, vida, maxVida);
		this.estatico = estatico;
		this.enemigo = enemigo;
	}

	@Override
	public void update() {
		if (enemigo) {
			// Comprobar visión
			if (inVision()) {
				System.out.println("En visión");
			}

		}
	}

	public boolean isEnemigo() {
		return enemigo;
	}

	public void setEnemigo(boolean enemigo) {
		this.enemigo = enemigo;
	}

	public boolean inVision() {
		int y1=0, y2=0; //variables de columna
		int x1=0, x2=0; //variables de fila

		switch (direccion) {
		
		case 1:
		case 2:
		case 3:
			
			
			break;
		case 4:
						
			break;
		case 5:
			y1=posY;
			y2=posY+getAlto();
			x1=posX;
			x2=posX+getAncho()/3*(12+3);
			
			break;
		case 6:
		case 7:
		case 8:
			y1=posY;
			y2=posY+getAlto()/3*(12+3);
			x1=posX;
			x2=posX+getAncho();
			
			break;
		}

		for (int i = y1; i < y2; i = i + getAlto() / 3) {
			for (int j = x1; j < x2; j = j + getAncho() / 3) {
				if (j == estatico.getPosX() && i == estatico.getPosY()) {
					return true;
				}
			}
		}

		return false;
	}
}
