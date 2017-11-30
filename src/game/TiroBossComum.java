package game;

public class TiroBossComum extends SuperTiro {

	public TiroBossComum(int posX, int posY, int velX, int dano) {
		super(posX, posY, 32, 16, "images/TiroBoss.png", velX, 0, dano, 1000);

	}

	public void update() {
		setPosX(getPosX() - getVelX());
	}
}
