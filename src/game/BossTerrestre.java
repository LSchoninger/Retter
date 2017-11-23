package game;

import br.senai.sc.engine.Utils;

public class BossTerrestre extends SuperInimigo {
	private int dano;

	public BossTerrestre() {
		super(1024, Utils.getInstance().getHeight() - 121, 217, 101, "images/Boss1.png", 15, 15, 0, 0, 4, 1, 5000);
	}

	public void update() {
		if (getPosX() >= 400) {
			setPosX(getPosX() - getVelX());

		}
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= 4) {
			setFrameX(0);
		}
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

}
