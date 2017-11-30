package game;

import br.senai.sc.engine.Utils;

public class TiroCanhao extends SuperTiro {
	private int contador;

	public TiroCanhao(int municao, int posX, int posY) {
		super(posX, posY, 20, 9, "images/TiroCanhao.png", 32, 32, 125, 25);
		setPosX(getPosX() + 90);
	}

	public void update(Nave nave) {
		if (contador <= 1 && nave.isArmaBaixo() && nave.isAtirandoCima() == false) {
			setPosY(nave.getPosY() + 22);
			contador++;
			// setMunicao(getMunicao() - 1);
		} else if (contador <= 1 && nave.isArmaCima() && nave.isAtirandoCima() == true) {
			setPosY(nave.getPosY() - 12);
			contador++;
			// setMunicao(getMunicao() - 1);
		}
		setPosX((getPosX()) + getVelX());
	}

}
