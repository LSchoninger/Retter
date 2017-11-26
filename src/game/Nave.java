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
	private boolean atirandoCanhao;
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
	private SuperArma[] armas;
	private TiroCanhao[] tiroCanhao;

	public Nave(int vidas, int hP) {
		super(50, 500, 106, 33, "images/TesteSheet.png", 17, 17, 0, 0, 4, 3);
		this.vidas = vidas;
		this.hP = hP;
		this.tiros = new TiroPadrao[7];
		tiroCanhao = new TiroCanhao[1000];
		variavelMunicaoLaser = 7;
		variavelMunicaoCimaLaser = 7;
		this.danoTiroPadrao = 100;
		armas = new SuperArma[8];
		armas[0] = new ArmaLaser(600, 400);
		armas[1] = new ArmaLaser(400, 600);
		armas[2] = new ArmaCanhao(130, 130);
		armas[3] = new ArmaCanhao(100, 100);
		// armas[6] e [7] sao baixo e cima;

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
			if (getPosY() <= 60) {
				setPosY(60);
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
		pegandoArmas();
		if (atirandoLaser) {
			tiroArmaLaser.update(this);
		} else {
			tiroArmaLaser = null;
		}
		// // if (atirandoCanhao) {
		// for (int i = 0; i < tiroCanhao.length; i++) {
		// if (tiroCanhao[i] != null) {
		// tiroCanhao[i].update(this);
		// }
		// }
		//
		//// }
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
		armaLaser(armas[6], armas[7]);
		armaCanhao(armas[6], armas[7]);
		tiroPadrao();
	}

	@Override
	public void draw(Graphics2D g) {
		if (tiroArmaLaser != null) {
			tiroArmaLaser.draw(g);
		}
		for (int i = 0; i < tiros.length; i++) {
			if (tiroCanhao[i] != null) {
				tiroCanhao[i].draw(g);
				tiroCanhao[i].update(this);
				if(tiroCanhao[i].isForaDaTela()){
					tiroCanhao[i]=null;
				}

			}
			if (tiros[i] != null) {
				tiros[i].draw(g);
				tiros[i].update();
				if (tiros[i].isForaDaTela()) {
					tiros[i] = null;
				}
			}
		}
		super.draw(g);
		if (armas[0] != null) {
			armas[0].draw(g);
		}
		if (armas[1] != null) {
			armas[1].draw(g);
		}
		if (armas[2] != null) {
			armas[2].draw(g);
		}
		if (armas[3] != null) {
			armas[3].draw(g);
		}
		if (armas[6] != null) {
			armas[6].draw(g);
		}
		if (armas[7] != null) {
			armas[7].draw(g);
		}
	}
	// terimna aqui

	public void RectangleChao(Ground ground) {
		getRectangle();
		ground.getRectangle();
		if (getRectangle().intersects(ground.getRectangle())) {
			sethP(gethP() - 50);
			setPosY(getPosY() - 75);
		}
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

	public void armaLaser(SuperArma armaDeBaixo, SuperArma armaDeCima) {

		if (armas[6] != null && armaDeBaixo != null && armaDeBaixo.getModeloDaArma() == 1 && armaBaixo
				&& atirandoCima == false && fimDaMunicao == false) {
			tiroArmaLaser = new TiroArmaLaser(variavelMunicaoLaser);
			atirandoLaser = true;
			variavelMunicaoLaser -= 1;
		} else if (armas[7] != null && armaDeCima != null && armaDeCima.getModeloDaArma() == 1 && armaCima
				&& atirandoCima == true && fimDaMunicaoCima == false) {
			tiroArmaLaser = new TiroArmaLaser(variavelMunicaoCimaLaser);
			atirandoLaser = true;
			variavelMunicaoCimaLaser -= 1;

		}

	}

	public void armaCanhao(SuperArma armaDeBaixo, SuperArma armaDeCima) {
		if (armas[6] != null && armaDeBaixo != null && armaDeBaixo.getModeloDaArma() == 2 && armaBaixo
				&& atirandoCima == false && fimDaMunicao == false) {
			for (int i = 0; i < tiroCanhao.length; i++) {
				if (tiroCanhao[i] == null) {
					atirandoCanhao = true;
					TiroCanhao t = new TiroCanhao(12, getPosX(), getPosY());
					tiroCanhao[i] = t;
					break;
				}
			}
		} else if (armas[7] != null && armaDeCima != null && armaDeCima.getModeloDaArma() == 2 && armaCima
				&& atirandoCima == true && fimDaMunicaoCima == false) {
			for (int i = 0; i < tiroCanhao.length; i++) {
				if (tiroCanhao[i] == null) {
					atirandoCanhao = true;
					TiroCanhao t = new TiroCanhao(12, getPosX(), getPosY());
					tiroCanhao[i] = t;
					break;
				}
			}
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

	public void pegandoArmas() {
		if (armas[0] != null) {
			if (armas[0].isPegou() == false) {
				armas[0].pegar(this);

			}
			if (armas[0].isPegou() == true) {
				armas[0].update(this);
				if (armas[0].isNaveCima() == false) {
					armas[6] = armas[0];
					armas[0] = null;

				} else if (armas[0].isNaveCima() == true) {
					armas[7] = armas[0];
					armas[0] = null;

				}
			}

		}
		if (armas[1] != null) {
			if (armas[1].isPegou() == false) {
				armas[1].pegar(this);

			}
			if (armas[1].isPegou() == true) {
				armas[1].update(this);
				if (armas[1].isNaveCima() == false) {
					armas[6] = armas[1];
					armas[1] = null;

				} else if (armas[1].isNaveCima() == true) {
					armas[7] = armas[1];
					armas[1] = null;
				}
			}

		}
		if (armas[2] != null) {
			if (armas[2].isPegou() == false) {
				armas[2].pegar(this);

			}
			if (armas[2].isPegou() == true) {
				armas[2].update(this);
				if (armas[2].isNaveCima() == false) {
					armas[6] = armas[2];
					armas[2] = null;
				} else if (armas[2].isNaveCima() == true) {
					armas[7] = armas[2];
					armas[2] = null;
				}
			}
		}
		if (armas[3] != null) {
			if (armas[3].isPegou() == false) {
				armas[3].pegar(this);

			}
			if (armas[3].isPegou() == true) {
				armas[3].update(this);
				if (armas[3].isNaveCima() == false) {
					armas[6] = armas[3];
					armas[3] = null;
				} else if (armas[3].isNaveCima() == true) {
					armas[7] = armas[3];
					armas[3] = null;
				}
			}
		}
		if (armas[6] != null) {
			armas[6].update(this);
		}
		if (armas[7] != null) {
			armas[7].update(this);
		}
	}

	public void possuiArmaNaPosicao() {
		for (int i = 0; i < armas.length; i++) {
			if (armas[i] != null) {
				if (armaCima && armas[i].pegar(this) && armas[7] != armas[i] && armas[6] != armas[i]) {
					armaBaixo = false;
					armas[6] = null;
				}
			}
		}
	}

	public void destruirArmas() {
		for (int j = 0; j < armas.length; j++) {
		}

	}

	public int getDanoTiroPadrao() {
		return danoTiroPadrao;
	}

	public void setDanoTiroPadrao(int danoTiroPadrao) {
		this.danoTiroPadrao = danoTiroPadrao;
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


	public SuperArma[] getArmas() {
		return armas;
	}

	public boolean isAtirandoCanhao() {
		return atirandoCanhao;
	}

	public void setAtirandoCanhao(boolean atirandoCanhao) {
		this.atirandoCanhao = atirandoCanhao;
	}

	public TiroCanhao[] getTiroCanhao() {
		return tiroCanhao;
	}

	public void setTiroCanhao(TiroCanhao[] tiroCanhao) {
		this.tiroCanhao = tiroCanhao;
	}

}
