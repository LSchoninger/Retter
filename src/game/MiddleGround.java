package game;

import br.senai.sc.engine.Utils;

public class MiddleGround extends ObjetoGraficoMovelComAnimacao {

	public MiddleGround(int posX) {
		super(posX, 640, 64, 128, "images/SonicBackground (1).png", 10, 0, 0, 0, 0, 0);

	}

	public void update() {
		setPosX(getPosX() - getVelX());
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= 4) {
			setFrameX(0);
		}
	}

	public void fimDaTela() {
		if (getPosX() + getWidth() <= 0) {
			setPosX(Utils.getInstance().getWidth() - 8);
		}
	}
}
