package game;

import java.awt.Graphics2D;

public class SquadTwo extends SuperSquad {
	private InimigoComum[] verbot = new InimigoComum[5];

	public SquadTwo(int hp) {
		super(1024, -150, false, 0, 0,"images/sonicDoMal.png");
		setControlTela(200);
		setHp(hp);
		setControl(5);
		setControle(false);

	}

	public void squadTwo() {
		for (int i = 0; i < verbot.length; i++) {
			verbot[i] = new InimigoComum(getHp(), getPosX(), getPosY() + getControlTela(),"images/sonic.png");
			setControlTela(getControlTela() + 125);
			verbot[i].setPosicaoTela(1);
			setVerbot(verbot);
			if (getControl() == 0) {
				setControle(true);
			}
		}
		verbot[1]=new InimigoComum(300,verbot[1].getPosX(),verbot[1].getPosY(),"images/sonicDoMal.png");
		verbot[3]=new InimigoComum(300,verbot[3].getPosX(),verbot[3].getPosY(),"images/sonicDoMal.png");
		verbot[1].setPosicaoTela(3);
		verbot[3].setPosicaoTela(3);
	}
}
