package game;

public class TiroArmaLaser extends SuperTiro {

	public TiroArmaLaser(int posX, int posY) {
		super(posX, posY, 800, 4, "images/TiroArmaLaser.png", 0, 0, 700);
	}

	public void update(Nave nave) {
		if (nave.isArmaBaixo()) {
			setPosX(nave.getPosX() + (nave.getWidth() / 2) + 40);
			setPosY(nave.getPosY() + 22);
		} else if (nave.isArmaCima()) {
			setPosX(nave.getPosX() + (nave.getWidth() / 2) + 40);
			setPosY(nave.getPosY() - 30);
		}
	}
}
