package game;

import java.util.Random;

public abstract class SuperInimigo extends ObjetoGraficoMovelComAnimacao {

	// Se chama super pois � a classe que os inimigos(inclusive BOSSE'S) v�o
	// herdar

	private int hp;

	public int getHp() {
		return hp;
	}

	public void setHp(int hP) {
		this.hp = hP;
	}

	public SuperInimigo(int posX, int posY, int width, int height, String fileName, int velX, int velY, int frameX,
			int frameY, int cols, int rows, int hp) {
		super(posX, posY, width, height, fileName, velX, velY, frameX, frameY, cols, rows);
		this.hp = hp;
	}

	// TODO COLIS�O NAVE, TIRO NAVE
	public void rectangleNave(Nave nave) {
		getRectangle();
		nave.getRectangle();
		if (getRectangle().intersects(nave.getRectangle())) {
			// vida por enquanto so destroi instan quase;
			setHp(getHp() - getHp() / 2);
			nave.sethP(getHp() - 350);
		}
	}

	public boolean rectangleTiro(SuperTiro[] tiros) {
		getRectangle();
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				tiros[i].getRectangle();
				if (getRectangle().intersects(tiros[i].getRectangle())) {
					setHp(getHp() - tiros[i].getDano());
					tiros[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public boolean rectangleArmaLaser(TiroArmaLaser tiro) {
		getRectangle();
		tiro.getRectangle();
		if (getRectangle().intersects(tiro.getRectangle())) {
			setHp(getHp() - tiro.getDano());
			return true;
		}
		return false;
	}

	public boolean rectangleArmaCanhao(TiroCanhao[] tiro) {
		getRectangle();
		for (int i = 0; i < tiro.length; i++) {
			if (tiro[i] != null) {
				tiro[i].getRectangle();
				if (getRectangle().intersects(tiro[i].getRectangle())) {
					setHp(getHp() - tiro[i].getDano());
					tiro[i]=null;
					return true;
				}
			}
		}

		return false;
	}
	public boolean atirar(int numero){
		Random rdm= new Random();
		if(rdm.nextInt(numero)==12){
			return true;
		}
		return false;
	}

}
