package game;

public class TiroPadrao extends SuperTiro {

	public TiroPadrao(int posX, int posY,int dano) {
		super(posX, posY, 3, 6, "images/TiroPadrao.png", 40, 40, dano);

	}

	public void update() {
		setPosX(getPosX() + getVelX());
	}
}
