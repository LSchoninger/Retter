package game;

import java.awt.Graphics2D;

public class SquadTwo extends InimigoComum {
	public SquadTwo(int hp) {
		super(0, 0, 0);
		this.posX = 1024;
		this.posY = -150;
		this.control = 200;
		this.hp = hp;
	}

	private InimigoComum[] verbot = new InimigoComum[5];
	private int posX;
	private int posY;
	private boolean controle;
	private int control;
	private int hp;

	public void squadTwo() {
		for (int i = 0; i < verbot.length; i++) {
			verbot[i] = new InimigoComum(hp, this.posX, posY + control);
			control += 200;
			verbot[i].setPosicaoTela(1);
		}
		verbot[1].setPosicaoTela(3);
		verbot[3].setPosicaoTela(3);
	}

	public void update() {
		for (int i = 0; i < verbot.length; i++) {
			if (verbot[i] != null) {
				verbot[i].update();
			}
		}
	}

	public void draw(Graphics2D g, int x, int z) {
		for (int i = 0; i < verbot.length; i++) {
			if (verbot[i] != null) {
				verbot[i].draw(g);
			}
		}
	}

	public void destruicaoSquad(SuperTiro[] tiro, Nave nave, TiroArmaLaser armaLaser) {
		for (int i = 0; i < verbot.length; i++) {
			if (verbot[i] != null) {
				verbot[i].rectangleNave(nave);
				if (armaLaser != null) {
					if (verbot[i]!=null&&verbot[i].rectangleArmaLaser(armaLaser)) {
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
					if (verbot[i]!=null&&verbot[i].rectangleTiro(tiro)) {
						if (verbot[i].getHp() <= 0) {
							verbot[i] = null;
						}
					}
				}
				
			}
		
		}
		
	}

	public InimigoComum[] getVerbot() {
		return verbot;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public boolean isControle() {
		return controle;
	}

	public int getHp() {
		return hp;
	}

	public void setVerbot(InimigoComum[] verbot) {
		this.verbot = verbot;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
