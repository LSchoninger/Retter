package game;

import java.awt.Graphics2D;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class BossFinal extends SuperInimigo {
	private int dano;
	private BossTiroMega[] superTiro;
	private boolean isAtirando;

	public BossFinal() {
		super(1024, 300, 360, 128, "images/boss2png.png", 7, 6, 0, 0, 0, 0, 12000);
		superTiro = new BossTiroMega[2];
	}

	public void update(TiroCanhao[] tiroCanhao, TiroArmaLaser tiroLaser, SuperTiro[] tiros, Nave nave) {
		if (getPosX() + getWidth() >= Utils.getInstance().getWidth()) {
			setPosX(getPosX() - getVelX());
		}
		setPosY(getPosY() + getVelY());

		if (getPosY() <= 65) {
			setVelY(getVelY() * -1);
		} else if (getPosY() + getHeight() >= Utils.getInstance().getHeight()) {
			setVelY(getVelY() * -1);
		}
		randomSuperTiro();
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

	public void megaTiro(Graphics2D g, TiroCanhao[] tiroCanhao, TiroArmaLaser tiroLaser, SuperTiro[] tiros, Nave nave) {
		for (int i = 0; i < superTiro.length; i++) {
			if (superTiro[i] == null) {
				superTiro[i] = new BossTiroMega(this);
				superTiro[0].setPosX(200);
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

		superTiro[0].update();
		superTiro[1].draw(g);
		if (superTiro[0].getPosX() <= 0) {
			for (int i = 0; i < superTiro.length; i++) {
				superTiro[i] = null;
			}
			isAtirando = false;
		}

	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public void randomSuperTiro() {
		Random rdm = new Random();
		if (rdm.nextInt(200) == 12) {
			isAtirando = true;
		}
	}

	public BossTiroMega[] getSuperTiro() {
		return superTiro;
	}

	public void setSuperTiro(BossTiroMega[] superTiro) {
		this.superTiro = superTiro;
	}

	public boolean isAtirando() {
		return isAtirando;
	}

	public void setAtirando(boolean isAtirando) {
		this.isAtirando = isAtirando;
	}

}
