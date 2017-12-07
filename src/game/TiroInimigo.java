package game;

public class TiroInimigo extends SuperTiro {

	public TiroInimigo(int posX, int posY, int velX, int dano) {
		super(posX, posY, 8, 20, "images/Tiro InimigoMaior.png", velX, 0, dano, 0);
	}

	@Override
	public void update() {
		setPosX(getPosX() - getVelX());
	}

}
