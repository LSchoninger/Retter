package game;

import java.awt.Graphics2D;

public class SquadTwo extends SuperSquad {
	private InimigoComum[] verbot = new InimigoComum[5];

	public SquadTwo(int hp) {
		super(1024, -150, false, 0, 0);
		setControlTela(200);
		setHp(hp);

	}

	public void squadTwo() {
		for (int i = 0; i < verbot.length; i++) {
			verbot[i] = new InimigoComum(getHp(), getPosX(), getPosY() + getControlTela());
			setControlTela(getControlTela() + 200);
			verbot[i].setPosicaoTela(1);
			setVerbot(verbot);
		}
		verbot[1].setPosicaoTela(3);
		verbot[3].setPosicaoTela(3);
	}
}
