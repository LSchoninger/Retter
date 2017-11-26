package game;

import java.awt.Graphics2D;

public class SquadTwo extends SuperSquad {
	private InimigoComum[] verbot = new InimigoComum[5];

	public SquadTwo(int hp) {
		super(1024, -150, false, 0, 0,"images/Verbot2.png");
		setControlTela(200);
		setHp(hp);
		setControl(5);
		setControle(false);

	}

	public void squadTwo() {
		for (int i = 0; i < verbot.length; i++) {
			verbot[i] = new InimigoComum(getHp(), getPosX(), getPosY() + getControlTela(),"images/Verbot2.png",4,45);
			setControlTela(getControlTela() + 125);
			verbot[i].setPosicaoTela(1);
			verbot[i].setWidth(63);
			verbot[i].setHeight(25);
			setVerbot(verbot);
			if (getControl() == 0) {
				setControle(true);
			}
		}
		verbot[1]=new InimigoComum(300,verbot[1].getPosX(),verbot[1].getPosY(),"images/Verbot1.png",4,50);
		verbot[3]=new InimigoComum(300,verbot[3].getPosX(),verbot[3].getPosY(),"images/Verbot1.png",4,50);
		verbot[1].setWidth(61);
		verbot[1].setHeight(22);
		verbot[3].setWidth(61);
		verbot[3].setHeight(22);
		verbot[1].setPosicaoTela(3);
		verbot[3].setPosicaoTela(3);
	}
}
