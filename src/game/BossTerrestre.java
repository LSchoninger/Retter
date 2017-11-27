package game;

import br.senai.sc.engine.Utils;

public class BossTerrestre extends SuperInimigo {
	private int dano;
	private boolean frente;

	public BossTerrestre() {
		super(1024, Utils.getInstance().getHeight() - 121, 217, 101, "images/Boss1.png", 15, 15, 0, 0, 4, 1, 7000);
	}

	public void update(TiroCanhao[] tiroCanhao, TiroArmaLaser tiroLaser, SuperTiro[] tiros, Nave nave) {
		if (getPosX() >= 0 && frente == false) {
			setPosX(getPosX() - getVelX()/2);
			if (getPosX() <= 0) {
				frente = true;
			}
		} else if (frente == true) {
			setPosX(getPosX() + getVelX() * 2);
			if (getPosX() + getWidth() >= Utils.getInstance().getWidth()) {
				frente = false;
			}

		}
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= 4) {
			setFrameX(0);
		}
		if (tiroCanhao != null) {
			rectangleArmaCanhao(tiroCanhao);
		}
		if (tiroLaser != null) {
			rectangleArmaLaser(tiroLaser);
		}
		if (tiros != null) {
			rectangleTiro(tiros);
		}
		rectangleNave(nave);
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public boolean isFrente() {
		return frente;
	}

	public void setFrente(boolean frente) {
		this.frente = frente;
	}

}
