package game;

import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class SquadOne extends InimigoComum {

	private InimigoComum[] verbot = new InimigoComum[3];
	private int posX;
	private int posY;
	private boolean controle;

	public SquadOne() {
		super(300, 0, 0);

	}

	public void squadOne() {
			
	}

	public void update() {
		for (int i = 0; i < verbot.length; i++) {
			verbot[i].update();
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
}
