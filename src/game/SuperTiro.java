package game;

public abstract class SuperTiro extends ObjetoGraficoMovel {

	// Super classe dos tiros, todos os projeteis vão herdar dessa classe
	private int dano;

	public SuperTiro(int posX, int posY, int width, int height, String fileName, int velX, int velY, int dano) {
		super(posX, posY, width, height, fileName, velX, velY);
		this.dano=dano;

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

}
