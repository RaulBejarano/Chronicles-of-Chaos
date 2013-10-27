package chronicles_zahin.pkg;


import android.graphics.Bitmap;

public class PEstatico extends Personaje {
	// 1=up-left, 2=up, 3=up-right 4=left ,5=right ,6=down-left, 7=down
	// ,8=down-right

	public PEstatico(int id, Mapa mapa, Bitmap imagen, String nombre, int posX,
			int posY, int vida, int maxVida) {
		super(id, mapa, imagen, nombre, posX, posY, vida, maxVida);
	}

	@Override
	public void update() {

		setCurrentFrame((getCurrentFrame() + 1) % 3);

		switch (getDireccion()) {

		case 1:
			setPosX(getPosX() - getAncho() / 3);
			setPosY(getPosY() - getAlto() / 3);
			break;
		case 2:
			setPosY(getPosY() - getAlto() / 3);
			break;
		case 3:
			setPosX(getPosX() + getAncho() / 3);
			setPosY(getPosY() - getAlto() / 3);
			break;
		case 4:
			setPosX(getPosX() - getAncho() / 3);
			break;
		case 5:
			setPosX(getPosX() + getAncho() / 3);
			break;
		case 6:
			setPosX(getPosX() - getAncho() / 3);
			setPosY(getPosY() + getAlto() / 3);
			break;
		case 7:
			setPosY(getPosY() + getAlto() / 3);
			break;
		case 8:
			setPosX(getPosX() + getAncho() / 3);
			setPosY(getPosY() + getAlto() / 3);

		}

	}

	public Nexo doNexo() {
		for (int i = 0; i < mapa.getNexo().size(); i++) {
			Nexo n = mapa.getNexo().get(i);
			switch (getDireccion()) {
			case 1:
			case 2:
			case 3:
				if (n.getDireccion() == 1) {
					if (getPosX() >= n.getPosX() - getAncho() * 2 / 3
							&& getPosX() <= n.getPosX() + getAncho() * 2 / 3
							&& getPosY() >= n.getPosY() - getAlto() * 2 / 3
							&& getPosY() <= n.getPosY() - getAlto() * 2 / 3) {
						return n;
					}
				}
				break;
			case 4:
				if (n.getDireccion() == 4) {
					if (getPosX() == n.getPosX()
							&& getPosY() >= n.getPosY() - getAlto() * 2 / 3
							&& getPosY() <= n.getPosY() + getAlto() * 2 / 3) {
						return n;
					}
				}
				break;
			case 5:
				if (n.getDireccion() == 2) {
					if (getPosX() == n.getPosX()
							&& getPosY() >= n.getPosY() - getAlto() * 2 / 3
							&& getPosY() <= n.getPosY() + getAlto() * 2 / 3) {
						return n;
					}
				}
				break;
			case 6:
			case 7:
			case 8:
				if (n.getDireccion() == 3) {
					if (getPosX() >= n.getPosX() - getAncho() * 2 / 3
							&& getPosX() <= n.getPosX() + getAncho() * 2 / 3
							&& getPosY() == n.getPosY()) {
						return n;
					}
				}
			}

		}
		return null;
	}

}
