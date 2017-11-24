package game;

public class SquadFive extends SuperSquad {
	private InimigoComum[] shades = new InimigoComum[5];

	public SquadFive(int hp) {
		super(1024, -150, false, hp, 5, "images/sonic.png");
		setControlTela(200);
		setHp(hp);
	}

	public void Squad5() {
		for (int i = 0; i < shades.length; i++) {
			shades[i] = new InimigoComum(getHp(), getPosX(), getPosY() + getControlTela(), "images/sonicDoMal3.png");
			setControlTela(getControlTela() + 125);
			shades[i].setPosicaoTela(6);
			setVerbot(shades);
			if (getControl() == 0) {
				setControle(true);
			}
		}
	}
}
