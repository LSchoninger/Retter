package game;

import br.senai.sc.engine.Utils;

public class BackGround extends ObjetoGraficoMovel {

	public BackGround(int posX) {
		super(posX, 0, 1024, 768, "Images/imagemTeste (2).jpg", 10, 0);

	}

	@Override
	public void update() {
		setPosX(getPosX() - getVelX());

	}

	public void fimDaTela() {
		if (getPosX() + getWidth() <= 0) {
			setPosX(Utils.getInstance().getWidth()-8);
		}
	}

}
