package game;

import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class SquadOne extends SuperSquad {
	private InimigoComum[] verbot = new InimigoComum[4];

	public SquadOne(int hp) {
		super(1024, -150, false, 0, 0, "");

		setControlTela(200);
		setHp(hp);
		setControl(4);
	}

	public void squadOne() {
		for (int i = 0; i < verbot.length; i++) {
			verbot[i] = new InimigoComum(getHp(), getPosX(), getPosY() + getControlTela(), "images/Verbot1.png",4,50);
			verbot[i].setPosicaoTela(1);
			verbot[i].setWidth(61);
			verbot[i].setHeight(22);
			setControlTela(getControlTela() + 150);
			setVerbot(verbot);
			if (getControl() == 0) {
				setControle(true);
			}
		}
//		verbot[2] = new InimigoComum(1000, 1024, 350, "images/sonic.png");
//		verbot[2].setPosicaoTela(1);
	}

}
