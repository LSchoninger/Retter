package game;

import java.awt.Graphics2D;
import java.awt.Image;

public abstract class SuperSquad extends InimigoComum {
	private int posX;
	private int posY;
	private boolean controle;
	private int controlTela;
	private int hp;
	private int control;
	private InimigoComum[] verbot;

	public SuperSquad(int posX, int posY, boolean controle, int hp, int control, String fileName) {
		super(0, 0, 0, fileName, 0, 0);
		this.posX = posX;
		this.posY = posY;
		this.hp = hp;
		this.control = control;
	}

	public void update(int velX, int dano, Nave nave) {
		if (verbot != null) {
			for (int i = 0; i < verbot.length; i++) {
				if (verbot[i] != null) {

					verbot[i].update(velX, dano);
					if (verbot[i].getTiro() != null) {
						verbot[i].getTiro().update();
						if (verbot[i].getTiro().getPosX() <= 0) {
							verbot[i].setTiro(null);
						}
						if (verbot[i].getTiro() != null && verbot[i].getTiro().RectangleNave(nave)) {
							nave.sethP(nave.gethP() - verbot[i].getTiro().getDano());
							verbot[i].setTiro(null);
						}
					}
				}
			}
		}
	}

	public void draw(Graphics2D g, int x, int z) {
		if (verbot != null) {
			for (int i = 0; i < verbot.length; i++) {
				if (verbot[i] != null) {
					verbot[i].draw(g);
					if (verbot[i].getTiro() != null) {
						verbot[i].getTiro().draw(g);
					}
				}
			}
		}
	}

	public void destruicaoSquad(SuperTiro[] tiro, Nave nave, TiroArmaLaser armaLaser, TiroCanhao[] canhao) {
		if (verbot != null) {
			for (int i = 0; i < verbot.length; i++) {
				if (verbot[i] != null) {
					verbot[i].rectangleNave(nave);
					if (armaLaser != null) {
						if (verbot[i] != null && verbot[i].rectangleArmaLaser(armaLaser)) {
							if (verbot[i].getHp() <= 0) {
								verbot[i] = null;
								control -= 1;
								if (control == 0) {
									controle = true;
								}
							}
						}
					}
					if (tiro != null) {
						if (verbot[i] != null && verbot[i].rectangleTiro(tiro)) {
							if (verbot[i].getHp() <= 0) {
								verbot[i] = null;
								control -= 1;
								if (control == 0) {
									controle = true;
								}
							}
						}
					}
					if (canhao != null) {
						if (verbot[i] != null && verbot[i].rectangleArmaCanhao(canhao)) {
							if (verbot[i].getHp() <= 0) {
								verbot[i] = null;
								control -= 1;
								if (control == 0) {
									controle = true;
								}
							}
						}
					}
				}
			}
		}
	}

	public InimigoComum[] getVerbot() {
		return verbot;
	}

	public void setVerbot(InimigoComum[] verbot) {
		this.verbot = verbot;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getControlTela() {
		return controlTela;
	}

	public int getControl() {
		return control;
	}

	public void setControlTela(int controlTela) {
		this.controlTela = controlTela;
	}

	public void setControl(int control) {
		this.control = control;
	}
}
