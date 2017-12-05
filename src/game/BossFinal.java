package game;

import java.awt.Graphics2D;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class BossFinal extends SuperInimigo {
	private int dano;
	private BossTiroMega[] superTiro;
	private boolean isAtirando;
	private TiroBossComum tiro;

	public BossFinal() {
		super(1024, 300, 384, 113, "images/Boss2V2.png", 7, 6, 0, 0, 2, 8, 12000);
		superTiro = new BossTiroMega[2];
	}

	public void update(TiroCanhao[] tiroCanhao, TiroArmaLaser tiroLaser, SuperTiro[] tiros, Nave nave, Graphics2D g,TiroArmaMissil[] missil) {
		if (getPosX() + getWidth() >= Utils.getInstance().getWidth()) {
			setPosX(getPosX() - getVelX());
		}
		setFrameY(0);
		setPosY(getPosY() + getVelY());
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= 8) {
			setFrameX(0);
		}

		if (getPosY() <= 65) {
			setVelY(getVelY() * -1);
		} else if (getPosY() + getHeight() >= Utils.getInstance().getHeight()) {
			setVelY(getVelY() * -1);
		}
		randomSuperTiro();
		if (tiroCanhao != null) {
			rectangleTiro(tiroCanhao);
		}
		if (tiroLaser != null) {
			rectangleArmaLaser(tiroLaser);
		}
		if (tiros != null) {
			rectangleTiro(tiros);
		}
		if(missil!=null){
			rectangleTiro(missil);
		}
		rectangleNave(nave);
		if (tiro == null) {
			tiro = new TiroBossComum(getPosX(), getPosY() + 5, 23, 300);

		}
		if (tiro != null) {
			tiro.draw(g);
			tiro.update();
			rectangleTiroComumBoss(nave);
		}
		if (tiro != null && tiro.getPosX() <= 0) {
			tiro = null;
		}
	}

	public void megaTiro(Graphics2D g, TiroCanhao[] tiroCanhao, TiroArmaLaser tiroLaser, SuperTiro[] tiros, Nave nave,TiroArmaMissil[] missil) {
		tiro = null;
		for (int i = 0; i < superTiro.length; i++) {
			setFrameY(1);
			setFrameX(getFrameX() + 1);
			if (getFrameX() >= 8) {
				setFrameX(0);
			}
			if (superTiro[i] == null) {
				superTiro[i] = new BossTiroMega(this);
				superTiro[0].setPosX(200);
			}
			if (tiroCanhao != null) {
				rectangleTiro(tiroCanhao);
			}
			if (tiroLaser != null) {
				rectangleArmaLaser(tiroLaser);
			}
			if (tiros != null) {
				rectangleTiro(tiros);
			}
			if(missil!=null){
				rectangleTiro(missil);
			}
			rectangleNave(nave);
		}

		superTiro[0].update();
		superTiro[1].draw(g);
		rectangleSuperMegaTiro(nave);
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

	public boolean rectangleSuperMegaTiro(Nave nave) {
		if (nave.isInvencivel() == false) {
			superTiro[1].getRectangle();
			nave.getRectangle();
			if (superTiro[1].getRectangle().intersects(nave.getRectangle())) {
				nave.sethP(nave.gethP() - superTiro[1].getDano());
				return true;
			}
		}
		return false;
	}

	public boolean rectangleTiroComumBoss(Nave nave) {
		if (nave.isInvencivel() == false) {
			tiro.getRectangle();
			nave.getRectangle();
			if (nave.getRectangle().intersects(tiro.getRectangle())) {
				nave.sethP(nave.gethP() - tiro.getDano());
				tiro = null;
				return true;
			}
		}
		return false;
	}

}
