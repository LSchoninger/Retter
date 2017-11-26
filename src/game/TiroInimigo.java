package game;

public class TiroInimigo extends SuperTiro {

	public TiroInimigo(int posX, int posY, int velX, int dano) {
		super(posX, posY, 3, 6, "images/TiroEnemy.png", velX, 0, dano, 0);
	}

	public void update() {
		setPosX(getPosX() - getVelX());
	}

}
