package game;

public class TiroCanhao extends SuperTiro {

	public TiroCanhao(int municao) {
		super(-6, -6, 20, 9, "images/TiroCanhao.png", 32, 32, 125, 25);

	}

	public void update(Nave nave) {
		if (nave.isArmaBaixo() && nave.isAtirandoCima() == false) {
			setPosX(nave.getPosX() + (nave.getWidth() / 2) + 40 + getVelX());
			setPosY(nave.getPosY() + 22);
			// setMunicao(getMunicao() - 1);
		} else if (nave.isArmaCima() && nave.isAtirandoCima() == true) {
			setPosX(nave.getPosX() + (nave.getWidth() / 2) + 40 + getVelX());
			setPosY(nave.getPosY() - 8);
			// setMunicao(getMunicao() - 1);
		}
	}
}
