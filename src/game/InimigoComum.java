package game;

import br.senai.sc.engine.Utils;

public class InimigoComum extends SuperInimigo {
	boolean destruido;
	private int posicaoTela;

	public InimigoComum(int hP, int posX, int posY) {
		super(posX, posY, 119, 112, "images/sonicDoMal.png", 15, 15, 0, 0, 7, 3, hP);

	}

	public void update() {
		setFrameY(1);
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= 7) {
			setFrameX(0);
		}
		if (getHp() <= 0) {
			destruido = true;
		} else {
			destruido = false;
		}
		if (posicaoTela == 1) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 2) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 2 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 3) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 3 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 4) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 4 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 5) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 5 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 6) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 6 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		}
	}

	public boolean isDestruido() {
		return destruido;
	}

	public void setDestruido(boolean destruido) {
		this.destruido = destruido;
	}

	public int getPosicaoTela() {
		return posicaoTela;
	}

	public void setPosicaoTela(int posicaoTela) {
		this.posicaoTela = posicaoTela;
	}

}
