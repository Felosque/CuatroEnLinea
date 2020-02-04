package cuatroenlinea.mundo;

public class Ficha {

	private int posX, posY, jugador;

	
	
	public Ficha(int pX, int pY, int pJugador) {
		posX = pX;
		posY = pY;
		jugador = pJugador;
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

	public int getJugador() {
		return jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}
	
	
}
