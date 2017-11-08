package game;

import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class Nave extends ObjetoGraficoMovelComAnimacao {

	private boolean upPressed;
	private boolean downPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean spacePressed;
	private boolean destruido;
	private boolean armaCima;
	private boolean atirandoLaser;
	private boolean armaBaixo;
	private int hP;
	private int vidas;
	private TiroArmaLaser tiroArmaLaser;
	private TiroPadrao[] tiros;

	public Nave(int vidas, int hP) {
		super(50, 500, 106, 33, "images/TesteSheet.png", 17, 17, 0, 0, 4, 3);
		this.vidas = vidas;
		this.hP = hP;
		this.tiros = new TiroPadrao[1000];
	}

	public boolean isUpPressed() {
		return upPressed;
	}

	public void setUpPressed(boolean upPressed) {
		this.upPressed = upPressed;
	}

	public boolean isDownPressed() {
		return downPressed;
	}

	public void setDownPressed(boolean downPressed) {
		this.downPressed = downPressed;
	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}

	public boolean isSpacePressed() {
		return spacePressed;
	}

	public void setSpacePressed(boolean spacePressed) {
		this.spacePressed = spacePressed;
	}

	public int gethP() {
		return hP;
	}

	public void sethP(int hP) {
		this.hP = hP;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public boolean isDestruido() {
		return destruido;
	}

	public void setDestruido(boolean destruido) {
		this.destruido = destruido;
	}

	public void update() {
		if (rightPressed) {
			// se para cima estiver Clicado ao mesmo tempo que para algum lado,
			// as velocidades são divididas, pois depois elas se somam
			if (upPressed || downPressed) {
				setPosX(getPosX() + (getVelX() / 2));
				setFrameY(0);
				setFrameX(getFrameX() + 1);
			} else {
				setPosX(getPosX() + getVelX());
				setFrameY(0);
				setFrameX(getFrameX() + 1);
			}
			if (getPosX() >= Utils.getInstance().getWidth() - getWidth()) {
				setPosX(Utils.getInstance().getWidth() - getWidth());
			}
		} else if (leftPressed) {
			if (upPressed || downPressed) {
				setPosX(getPosX() - (getVelX() / 2));
				setFrameX(0);
			} else {
				setPosX(getPosX() - getVelX());
				setFrameX(0);
			}
			if (getPosX() <= 0) {
				setPosX(0);
			}
		}
		if (leftPressed == false && rightPressed == false && upPressed == false && downPressed == false) {
			setFrameX(0);
			setFrameY(0);
		}

		if (upPressed) {
			if (rightPressed || leftPressed) {
				setPosY(getPosY() - (getVelY() / 2));
				setFrameY(1);
				setFrameX(getFrameX() + 1);
			} else {
				setFrameY(1);
				setFrameX(getFrameX() + 1);
				setPosY(getPosY() - getVelY());
			}
			if (getPosY() <= 0) {
				setPosY(0);
			}
		} else if (downPressed) {
			if (rightPressed || leftPressed) {
				setPosY(getPosY() + (getVelY() / 2));
				setFrameY(2);
				setFrameX(getFrameX() + 1);
			} else {
				setPosY(getPosY() + getVelY());
				setFrameY(2);
				setFrameX(getFrameX() + 1);
			}
			if (getPosY() >= Utils.getInstance().getHeight() - getHeight()) {
				setPosY(Utils.getInstance().getHeight() - getHeight());
			}
		}
		if (atirandoLaser) {
			tiroArmaLaser.update(this);
		} else {
			tiroArmaLaser = null;
		}
		if (gethP() <= 0) {
			setPosX(50);
			setPosY(500);
			sethP(700);
			setVidas(getVidas() - 1);
			if (getVidas() <= 0) {
				destruido = true;
			}
		} else {
			destruido = false;
		}
		super.update();
	}

	public void atirar() {
		if (armaBaixo) {
			tiroArmaLaser = new TiroArmaLaser(getPosX() + (getWidth() / 2) + 40, getPosY() + 22);
			atirandoLaser = true;
		} else if (armaCima) {
			tiroArmaLaser = new TiroArmaLaser(getPosX() + (getWidth() / 2) + 40, getPosY() -30);
			atirandoLaser = true;
		}
		if (!armaCima || !armaBaixo) {
			for (int i = 0; i < tiros.length; i++) {
				if (tiros[i] == null) {
					TiroPadrao t = new TiroPadrao(getPosX() + getWidth(), this.getPosY() + 12, 100);
					tiros[i] = t;
					break;
				}
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if (tiroArmaLaser != null) {
			tiroArmaLaser.draw(g);
		}
		for (int i = 0; i < tiros.length; i++) {

			if (tiros[i] != null) {
				tiros[i].draw(g);
				tiros[i].update();

			}
		}
		super.draw(g);
	}
	// terimna aqui

	public TiroPadrao[] getTiros() {

		return tiros;
	}

	public void setTiros(TiroPadrao[] tiros) {
		this.tiros = tiros;
	}

	public boolean isArmaCima() {
		return armaCima;
	}

	public void setArmaCima(boolean armaCima) {
		this.armaCima = armaCima;
	}

	public boolean isArmaBaixo() {
		return armaBaixo;
	}

	public void setArmaBaixo(boolean armaBaixo) {
		this.armaBaixo = armaBaixo;
	}

	public TiroArmaLaser getTiroArmaLaser() {
		return tiroArmaLaser;
	}

	public void setTiroArmaLaser(TiroArmaLaser tiroArmaLaser) {
		this.tiroArmaLaser = tiroArmaLaser;
	}

	public boolean isAtirandoLaser() {
		return atirandoLaser;
	}

	public void setAtirandoLaser(boolean atirandoLaser) {
		this.atirandoLaser = atirandoLaser;
	}

	public void RectangleChao(Ground ground) {
		getRectangle();
		ground.getRectangle();
		if (getRectangle().intersects(ground.getRectangle())) {
			sethP(gethP() - 50);
			setPosY(getPosY() - 75);
		}
	}
}
