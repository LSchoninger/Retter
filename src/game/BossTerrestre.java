package game;

import java.awt.Graphics2D;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class BossTerrestre extends SuperInimigo {
	private int dano;
	private boolean frente;
	private TiroBossTerrestre[] tiros = new TiroBossTerrestre[9];
	private int x = 860;

	public BossTerrestre() {
		super(1024, Utils.getInstance().getHeight()-240, 213, 213, "images/Boss1V2.png", 15, 15, 0, 0, 4, 1, 7000);

	}

	public void update(TiroCanhao[] tiroCanhao, TiroArmaLaser tiroLaser, SuperTiro[] tiros, Nave nave, Graphics2D g,TiroArmaMissil[] missil) {
		Random rdm = new Random();
		if (getPosX() >= 0 && frente == false) {
			setPosX(getPosX() - getVelX());
			if (getPosX() <= 0) {
				frente = true;
			}
		} else if (frente == true) {
			setPosX(getPosX() + getVelX()/2);
			if (getPosX() + getWidth() >= Utils.getInstance().getWidth()) {
				frente = false;
			}

		}
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= 4) {
			setFrameX(0);
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
		// atirando();
		// tiros[rdm.nextInt(7)] = null;
		for (int i = 0; i < tiros.length; i++) {
			if (this.tiros[i] == null) {
				if(x<=80){
					x=900;
					System.out.println(getPosX());
				}
				if (getPosX()+getWidth() >= x && getPosX() <= x +15) {
					this.tiros[i] = new TiroBossTerrestre((getPosX()), getPosY());
					x -= 120;
				}
			}
			if (this.tiros[i] != null) {
				this.tiros[i].update();
				this.tiros[i].draw(g);
				if(this.tiros[i].RectangleNave(nave)){
					nave.sethP(nave.gethP()-450);
					this.tiros[i]=null;
				}
				if(this.tiros[i]!=null&&this.tiros[i].getPosY()<=0){
					this.tiros[i]=null;
				}
			}
		}
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

	public void atirando() {
		int x = 100;
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] == null) {
				tiros[i] = new TiroBossTerrestre(100, 114);
				x += 119;
				if (x >= Utils.getInstance().getWidth()) {
					x = 0;
				}

			}
		}
	}

}
