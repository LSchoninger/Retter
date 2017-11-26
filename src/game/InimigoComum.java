package game;

import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class InimigoComum extends SuperInimigo {
	private boolean destruido;
	private int posicaoTela;
	private TiroInimigo tiro;
	private int frequenciaDeTiros;

	public InimigoComum(int hP, int posX, int posY, String fileName, int cols, int frequenciaDeTiros) {
		super(posX, posY, 120, 33, fileName, 15, 5, 0, 0, 7, 3, hP);
		setVelY(2);
		setCols(cols);
		setFrequenciaDeTiros(frequenciaDeTiros);
	}

	public void update(int velX, int dano) {
		setFrameY(0);
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= getCols()) {
			setFrameX(0);
		}
		if (getHp() <= 0) {
			destruido = true;
		} else {
			destruido = false;
		}
		// if (posicaoTela == 0) {
		// setPosY(getPosY() + getVelY());
		// if (RectangleAnother(enemy)) {
		// setVelY(getVelY() * -1);
		// enemy.setVelY(getVelY() * -1);
		// }
		// if (getPosY() <= 0) {
		// setPosY(0);
		// setVelY(getVelY() * -1);
		// }
		// if (getPosY()+getHeight() >= Utils.getInstance().getHeight()) {
		// setPosY(Utils.getInstance().getHeight() - getHeight());
		// setVelY(getVelY() * -1);
		// }}
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
		if (tiro == null && atirar(frequenciaDeTiros)) {
			tiro = new TiroInimigo(getPosX(), getPosY() + 10, velX, dano);
		}
	}

	public boolean RectangleAnother(InimigoComum enemy) {
		getRectangle();
		enemy.getRectangle();
		if (getRectangle().intersects(enemy.getRectangle())) {
			return true;
		}
		return false;
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

	public TiroInimigo getTiro() {
		return tiro;
	}

	public void setTiro(TiroInimigo tiro) {
		this.tiro = tiro;
	}

	public int getFrequenciaDeTiros() {
		return frequenciaDeTiros;
	}

	public void setFrequenciaDeTiros(int frequenciaDeTiros) {
		this.frequenciaDeTiros = frequenciaDeTiros;
	}

}
