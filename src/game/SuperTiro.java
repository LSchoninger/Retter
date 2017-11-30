package game;

import br.senai.sc.engine.Utils;

public abstract class SuperTiro extends ObjetoGraficoMovel {

	// Super classe dos tiros, todos os projeteis vão herdar dessa classe
	private int dano;
	private int municao;

	public SuperTiro(int posX, int posY, int width, int height, String fileName, int velX, int velY, int dano,
			int municao) {
		super(posX, posY, width, height, fileName, velX, velY);
		this.dano = dano;
		this.municao = municao;
	}

	@Override
	public void update() {

	}

	public void Rectangle(Object o) {

	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getMunicao() {
		return municao;
	}

	public void setMunicao(int municao) {
		this.municao = municao;
	}

	public boolean isForaDaTela() {
		if (getPosX() >= Utils.getInstance().getWidth()) {
			return true;
		}
		return false;

	}

	public boolean RectangleNave(Nave nave) {
		if (nave.isInvencivel() == false) {
			getRectangle();
			nave.getRectangle();
			if (getRectangle().intersects(nave.getRectangle())) {
				return true;
			}

		}
		return false;
	}

}
