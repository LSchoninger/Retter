package game;

public class TiroArmaLaser extends SuperTiro {

	public TiroArmaLaser() {
		super(-6, -6, 800, 4, "images/TiroArmaLaser.png", 0, 0, 50, 50);
	}

	public void update(Nave nave) {
		if (nave.isArmaBaixo() && nave.isAtirandoCima() == false) {
			setPosX(nave.getPosX() + (nave.getWidth() / 2) + 40);
			setPosY(nave.getPosY() + 22);
			// setMunicao(getMunicao() - 1);
		} else if (nave.isArmaCima() && nave.isAtirandoCima() == true) {
			setPosX(nave.getPosX() + (nave.getWidth() / 2) + 40);
			setPosY(nave.getPosY() - 8);
			// setMunicao(getMunicao() - 1);
		}

	}

	public boolean fimDeMunicao() {
		if (getMunicao() <= 0) {
			return true;
		} else {
			return false;
		}
	}
}
