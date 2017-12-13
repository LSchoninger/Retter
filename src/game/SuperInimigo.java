package game;

import java.util.Random;

public abstract class SuperInimigo extends ObjetoGraficoMovelComAnimacao {

	// Se chama super pois é a classe que os inimigos(inclusive BOSSE'S) vão
	// herdar

	private int hp;
	private boolean lifebar;
	private EnemyLifebar bar;

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
		setBar(new EnemyLifebar(getPosX(), getPosY()));
	}

	// TODO COLISÃO NAVE, TIRO NAVE
	public void rectangleNave(Nave nave) {
		if (nave.isInvencivel() == false) {
			getRectangle();
			nave.getRectangle();
			if (getRectangle().intersects(nave.getRectangle())) {
				// vida por enquanto so destroi instan quase;
				nave.sethP(nave.gethP() - nave.gethP());
			}
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

	public boolean atirar(int numero) {
		Random rdm = new Random();
		if (rdm.nextInt(numero) == 12) {
			return true;
		}
		return false;
	}

	public EnemyLifebar getBar() {
		return bar;
	}

	public void setBar(EnemyLifebar bar) {
		this.bar = bar;
	}

}
