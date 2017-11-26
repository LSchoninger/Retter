package game;

import br.senai.sc.engine.Utils;

public class BossFinal extends SuperInimigo {
	private int dano;

	public BossFinal() {
		super(1024, 300, 360, 128, "images/boss2png.png", 7, 6, 0, 0, 0, 0, 12000);

	}

	public void update() {
		if (getPosX() + getWidth() >= Utils.getInstance().getWidth()) {
			setPosX(getPosX() - getVelX());
		}
		setPosY(getPosY() + getVelY());
		if (getPosY() <= 0) {
			setVelY(getVelY() * -1);
		} else if (getPosY() + getHeight() >= Utils.getInstance().getHeight()) {
			setVelY(getVelY() * -1);
		}
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

}
