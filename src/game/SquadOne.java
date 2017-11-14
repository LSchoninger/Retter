package game;

import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class SquadOne extends InimigoComum {

	private InimigoComum[] verbot = new InimigoComum[5];
	private int posX;
	private int posY;
	private boolean controle;
	private int control;
	private int hp;

	public SquadOne(int hp) {
		super(300, 0, 0);
		this.posX = 1024;
		this.posY = -150;
		this.control = 200;
	}

	public void squadOne() {
		for (int i = 0; i < verbot.length; i++) {
			verbot[i] = new InimigoComum(700, this.posX, posY + control);
			control += 150;
		}
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
					verbot[i].rectangleArmaLaser(armaLaser);
				}
				if (tiro != null) {
					if (verbot[i].rectangleTiro(tiro)) {
						verbot[i].setHp(getHp() - 100);
						if(getHp()<=0){
							verbot[i]=null;
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
}
