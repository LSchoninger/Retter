package game;

import br.senai.sc.engine.Utils;

public class MiddleGround extends ObjetoGraficoMovelComAnimacao {

	public MiddleGround(int posX) {
		super(posX, -23, 1024, 768, "images/meiopredios.png", 10, 0, 0, 0, 0, 0);

	}

	public void update() {
		setPosX(getPosX() - getVelX());

	}

	public void fimDaTela() {
		if (getPosX() + getWidth() <= 0) {
			setPosX(Utils.getInstance().getWidth() - 8);
		}
	}
}
