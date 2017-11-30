package game;

public class SquadSix extends SuperSquad {
	private InimigoComum[] shades = new InimigoComum[5];

	public SquadSix(int hp) {
		super(1024, -150, false, hp, 5, "");
		setControlTela(200);
		setHp(hp);
	}

	public void Squad6() {
		for (int i = 0; i < shades.length; i++) {
			shades[i] = new InimigoComum(getHp(), getPosX(), getPosY() + getControlTela(), "images/Shades3.png",5,35);
			setControlTela(getControlTela() + 125);
			shades[i].setPosicaoTela(5);
			setVerbot(shades);
			if (getControl() == 0) {
				setControle(true);
			}
			shades[1] = new InimigoComum(getHp(), 1024, 175, "images/Shades3.png",5,35);
			shades[3] = new InimigoComum(getHp(),1024,425, "images/Shades3.png",5,35);
			shades[2] = new InimigoComum(2000, 1024, 300, "images/Shades3General.png",5,24);
			shades[1].setPosicaoTela(3);
			shades[3].setPosicaoTela(3);
			shades[2].setPosicaoTela(1);
		}
	}
}
