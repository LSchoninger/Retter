package game;

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
	public void RectangleNave(Nave nave) {
		getRectangle();
		nave.getRectangle();
		if (getRectangle().intersects(nave.getRectangle())) {
			// vida por enquanto so destroi instan quase;
			setHp(getHp() - getHp() / 2);
			nave.sethP(getHp() - 350);
		}
	}

	public void RectangleTiro(SuperTiro[] tiros) {
		getRectangle();
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				tiros[i].getRectangle();
				if (getRectangle().intersects(tiros[i].getRectangle())) {
					setHp(getHp() - tiros[i].getDano());
					tiros[i] = null;
				}
			}
		}
	}

	public void RectangleArmaLaser(TiroArmaLaser tiro) {
		getRectangle();
		tiro.getRectangle();
		if (getRectangle().intersects(tiro.getRectangle())) {
			setHp(getHp() - tiro.getDano());
			
		}
	}

}