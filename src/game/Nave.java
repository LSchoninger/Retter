package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;

import br.senai.sc.engine.Utils;

public class Nave extends ObjetoGraficoMovelComAnimacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3180054105550148679L;
	private boolean upPressed;
	private boolean downPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean destruido;
	private boolean armaCima;
	private boolean atirandoCanhao;
	private boolean atirandoMissil;
	private boolean atirandoLaser;
	private boolean armaBaixo;
	private boolean atirandoCima;
	private boolean invencivel;
	private boolean fimDaMunicao;
	private boolean fimDaMunicaoCima;
	private int hP;
	private int hPInicial;
	private int vidas;
	private long pontuacao;
	private TiroArmaLaser tiroArmaLaser;
	private TiroPadrao[] tiros;
	private TiroArmaMissil[] missil;
	private int danoTiroPadrao;
	private SuperArma[] armas;
	private TiroCanhao[] tiroCanhao;
	private int start;
	private int escolha;

	public Nave(int vidas, int hP, String fileName) {
		// int posX, int posY, int width, int height, String fileName, int velX,
		// int velY,
		// int frameX, int frameY, int cols, int rows
		super(50, 500, 120, 39, fileName, 17, 17, 0, 0, 6, 3);
		this.vidas = vidas;
		this.hP = hP;
		hPInicial = hP;
		this.missil = new TiroArmaMissil[7];
		this.tiros = new TiroPadrao[7];
		tiroCanhao = new TiroCanhao[1000];
		this.danoTiroPadrao = 100;
		// Super arma : arma[0]= baixo/arma[1]=cima
		armas = new SuperArma[4];

	}

	public void update() {
		controleDaNave();
		pegandoArmas();
		if (start >= 100) {
			invencivel = false;
		}
		start++;
		if (atirandoLaser) {
			tiroArmaLaser.update(this);
		} else {
			tiroArmaLaser = null;
		}
		if (gethP() <= 0) {
			setPosX(50);
			setPosY(500);
			sethP(hPInicial);
			setVidas(getVidas() - 1);
			invencivel = true;
			start = 0;

			if (getVidas() <= 0) {
				destruido = true;
			}
		} else {
			destruido = false;
		}
		super.update();
	}

	public void atirar() {
		armaLaser(armas[2], armas[3]);
		armaCanhao(armas[2], armas[3]);
		armaMissil(armas[2], armas[3]);
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
				if (tiroCanhao[i].isForaDaTela()) {
					tiroCanhao[i] = null;
				}

			}
			if (missil[i] != null) {
				missil[i].draw(g);
				missil[i].update(this);
				if (missil[i].isForaDaTela()) {
					missil[i] = null;
				}
			}
			if (tiros[i] != null) {
				tiros[i].draw(g);
				tiros[i].update(this);
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
			if (armaCima == true) {
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

		if (armas[2] != null && armaDeBaixo != null && armaDeBaixo.getModeloDaArma() == 1 && armaBaixo
				&& atirandoCima == false && fimDaMunicao == false) {
			tiroArmaLaser = new TiroArmaLaser();
			atirandoLaser = true;
			for (int i = 0; i < armas[2].getMunicao(); i++) {
				armas[2].setMunicao(armas[2].getMunicao() - 1);
			}
			if (armas[2].getMunicao() <= 0) {
				armas[2] = null;
				armaDeBaixo =null;
				armaBaixo=false;
			}
		} else if (armas[3] != null && armaDeCima != null && armaDeCima.getModeloDaArma() == 1 && armaCima
				&& atirandoCima == true && fimDaMunicaoCima == false) {
			tiroArmaLaser = new TiroArmaLaser();
			atirandoLaser = true;
			armas[3].setMunicao(armas[3].getMunicao() - 1);
			if (armas[3].getMunicao() <= 0) {
				armas[3] = null;
				armaDeCima=null;
				armaCima=false;
			}
		}

	}

	public void armaMissil(SuperArma armaDeBaixo, SuperArma armaDeCima) {
		if (armas[2] != null && armaDeBaixo != null && armaDeBaixo.getModeloDaArma() == 3 && armaBaixo
				&& atirandoCima == false && fimDaMunicao == false) {
			for (int i = 0; i < missil.length; i++) {
				if (missil[i] == null) {
					atirandoMissil = true;
					TiroArmaMissil t = new TiroArmaMissil(getPosX(), getPosY(), 12);
					missil[i] = t;
					armas[2].setMunicao(armas[2].getMunicao() - 1);
					if (armas[2].getMunicao() <= 0) {
						armas[2] = null;
						armaDeBaixo =null;
						armaBaixo=false;
					}
					break;
				}
			}
		} else if (armas[3] != null && armaDeCima != null && armaDeCima.getModeloDaArma() == 3 && armaCima
				&& atirandoCima == true && fimDaMunicaoCima == false) {
			for (int i = 0; i < missil.length; i++) {
				if (missil[i] == null) {
					atirandoMissil = true;
					TiroArmaMissil t = new TiroArmaMissil(getPosX(), getPosY(), 12);
					missil[i] = t;
					armas[3].setMunicao(armas[3].getMunicao() - 1);
					if (armas[3].getMunicao() <= 0) {
						armas[3] = null;
						armaDeCima=null;
						armaCima=false;
					}
					break;
				}
			}
		}
	}

	public void armaCanhao(SuperArma armaDeBaixo, SuperArma armaDeCima) {
		if (armas[2] != null && armaDeBaixo != null && armaDeBaixo.getModeloDaArma() == 2 && armaBaixo
				&& atirandoCima == false && fimDaMunicao == false) {
			for (int i = 0; i < tiroCanhao.length; i++) {
				if (tiroCanhao[i] == null) {
					atirandoCanhao = true;
					TiroCanhao t = new TiroCanhao(12, getPosX(), getPosY());
					tiroCanhao[i] = t;
					armas[2].setMunicao(armas[2].getMunicao() - 1);
					if (armas[2].getMunicao() <= 0) {
						armas[2] = null;
						armaDeBaixo =null;
						armaBaixo=false;
					}
					break;
				}
			}
		} else if (armas[3] != null && armaDeCima != null && armaDeCima.getModeloDaArma() == 2 && armaCima
				&& atirandoCima == true && fimDaMunicaoCima == false) {
			for (int i = 0; i < tiroCanhao.length; i++) {
				if (tiroCanhao[i] == null) {
					atirandoCanhao = true;
					TiroCanhao t = new TiroCanhao(12, getPosX(), getPosY());
					tiroCanhao[i] = t;
					armas[3].setMunicao(armas[3].getMunicao() - 1);
					if (armas[3].getMunicao() <= 0) {
						armas[3] = null;
						armaDeCima=null;
						armaCima=false;
					}
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
				armas[0].update();
				armas[0].pegar(this);
				if (armas[0].getPosX() + armas[0].getWidth() <= 0) {
					armas[0] = null;
				}

			}
			if (armas[0] != null) {
				if (armas[0].isPegou() == true) {
					armas[0].update(this);
					if (armas[0].isNaveCima() == false) {
						armas[2] = armas[0];
						armas[0] = null;

					} else if (armas[0].isNaveCima() == true) {
						armas[3] = armas[0];
						armas[0] = null;

					}
				}

			}
		}
		if (armas[1] != null) {
			if (armas[1].isPegou() == false) {
				armas[1].pegar(this);
				armas[1].update();
				if (armas[1].getPosX() + armas[1].getWidth() <= 0) {
					armas[1] = null;
				}

			}
			if (armas[1] != null) {
				if (armas[1].isPegou() == true) {
					armas[1].update(this);
					if (armas[1].isNaveCima() == false) {
						armas[2] = armas[1];
						armas[1] = null;

					} else if (armas[1].isNaveCima() == true) {
						armas[3] = armas[1];
						armas[1] = null;
					}
				}

			}
		}

		if (armas[2] != null) {
			armas[2].update(this);
		}
		if (armas[3] != null) {
			armas[3].update(this);
		}
	}

	// public void possuiArmaNaPosicao() {
	// for (int i = 0; i < armaso.length; i++) {
	// if (armaso[i] != null) {
	// if (armaCima && armaso[i].pegar(this) && armaso[3] != armaso[i] &&
	// armaso[2] != armaso[i]) {
	// armaBaixo = false;
	// armaso[0] = null;
	// }
	// }
	// }
	// }

	public void controleDaNave() {
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

	public SuperArma[] getArmaso() {
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

	public void setArmaso(SuperArma armas) {
		for (int j = 0; j < 2; j++) {
			if (this.armas[j] == null) {
				this.armas[j] = armas;
			}
		}

	}

	public boolean isInvencivel() {
		return invencivel;
	}

	public void setInvencivel(boolean invencivel) {
		this.invencivel = invencivel;
	}

	public TiroArmaMissil[] getMissil() {
		return missil;
	}

	public void setMissil(TiroArmaMissil[] missil) {
		this.missil = missil;
	}

	public boolean isAtirandoMissil() {
		return atirandoMissil;
	}

	public int getEscolha() {
		return escolha;
	}

	public void setEscolha(int escolha) {
		this.escolha = escolha;
	}

	public void setAtirandoMissil(boolean atirandoMissil) {
		this.atirandoMissil = atirandoMissil;
	}

	public long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(long pontuacao) {
		this.pontuacao = pontuacao;
	}

}
