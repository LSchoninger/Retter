package game;

import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class Nave extends ObjetoGraficoMovelComAnimacao {

	private boolean upPressed;
	private boolean downPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean destruido;
	private boolean armaCima;
	private boolean atirandoLaser;
	private boolean armaBaixo;
	private boolean atirandoCima;
	private boolean fimDaMunicao;
	private boolean fimDaMunicaoCima;
	private int variavelMunicaoLaser;
	private int variavelMunicaoCimaLaser;
	private int hP;
	private int vidas;
	private TiroArmaLaser tiroArmaLaser;
	private TiroPadrao[] tiros;
	private int danoTiroPadrao;
	private ArmaLaser armaLaserBaixo;
	private ArmaLaser armaLaserCima;

	public Nave(int vidas, int hP) {
		super(50, 500, 106, 33, "images/TesteSheet.png", 17, 17, 0, 0, 4, 3);
		this.vidas = vidas;
		this.hP = hP;
		this.tiros = new TiroPadrao[1000];
		variavelMunicaoLaser = 7;
		variavelMunicaoCimaLaser = 7;
		this.danoTiroPadrao = 100;
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
		armaLaser();
		tiroPadrao();
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

	public boolean isAtirandoCima() {
		return atirandoCima;
	}

	public boolean isFimDaMunicaoCima() {
		return fimDaMunicaoCima;
	}

	public void setFimDaMunicaoCima(boolean fimDaMunicaoCima) {
		this.fimDaMunicaoCima = fimDaMunicaoCima;
	}

	public boolean isFimDaMunicao() {
		return fimDaMunicao;
	}

	public void setFimDaMunicao(boolean fimDaMunicao) {
		this.fimDaMunicao = fimDaMunicao;
	}

	public void setAtirandoCima(boolean atirandoCima) {
		this.atirandoCima = atirandoCima;
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

	public int getVariavelMunicaoLaser() {
		return variavelMunicaoLaser;
	}

	public void setVariavelMunicaoLaser(int variavelMunicao) {
		this.variavelMunicaoLaser = variavelMunicao;
	}

	public int getVariavelMunicaoCimaLaser() {
		return variavelMunicaoCimaLaser;
	}

	public void setVariavelMunicaoCimaLaser(int variavelMunicaoCimaLaser) {
		this.variavelMunicaoCimaLaser = variavelMunicaoCimaLaser;
	}

	public void atirandoArmaLaser() {
		if (tiroArmaLaser != null) {
			tiroArmaLaser.update(this);
			if (armaBaixo == true) {
				if (tiroArmaLaser.fimDeMunicao() == true) {
					fimDaMunicao = true;
					tiroArmaLaser = null;
				}
			}
			if (armaCima == true && variavelMunicaoCimaLaser <= 0) {
				if (tiroArmaLaser != null) {
					if (tiroArmaLaser.fimDeMunicao() == true) {
						fimDaMunicaoCima = true;
						tiroArmaLaser = null;
					}
				}
			}
		} else {
			tiroArmaLaser = null;
		}
	}

	public void armaLaser() {
		if (armaBaixo && atirandoCima == false && fimDaMunicao == false) {
			tiroArmaLaser = new TiroArmaLaser(variavelMunicaoLaser);
			atirandoLaser = true;
			variavelMunicaoLaser -= 1;
		} else if (armaCima && atirandoCima == true && fimDaMunicaoCima == false) {
			tiroArmaLaser = new TiroArmaLaser(variavelMunicaoCimaLaser);
			atirandoLaser = true;
			variavelMunicaoCimaLaser -= 1;

		}
	}

	public void tiroPadrao() {
		if (!armaCima || !armaBaixo) {
			for (int i = 0; i < tiros.length; i++) {
				if (tiros[i] == null) {
					TiroPadrao t = new TiroPadrao(getPosX() + getWidth(), this.getPosY() + 12, danoTiroPadrao);
					tiros[i] = t;
					break;
				}
			}
		}
	}

	public int getDanoTiroPadrao() {
		return danoTiroPadrao;
	}

	public void setDanoTiroPadrao(int danoTiroPadrao) {
		this.danoTiroPadrao = danoTiroPadrao;
	}

	public ArmaLaser getArmaLaserBaixo() {
		return armaLaserBaixo;
	}

	public ArmaLaser getArmaLaserCima() {
		return armaLaserCima;
	}

	public void setArmaLaserBaixo(ArmaLaser armaLaserBaixo) {
		this.armaLaserBaixo = armaLaserBaixo;
	}

	public void setArmaLaserCima(ArmaLaser armaLaserCima) {
		this.armaLaserCima = armaLaserCima;
	}
}
