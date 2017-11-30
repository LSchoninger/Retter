package game;

import br.senai.sc.engine.Utils;

public class Ground extends ObjetoGraficoMovel {
	private int dano;

	public Ground(int dano, int posX) {
		super(posX, Utils.getInstance().getHeight()-30, 2000, 150, "images/ground.png", 15, 0);
		this.dano = dano;
	}

	@Override
	public void update() {
		setPosX(getPosX() - getVelX());
	}

	public void fimDaTela() {
		if (getPosX() + getWidth() <= 0) {
			setPosX(Utils.getInstance().getWidth());
		}
	}

}
