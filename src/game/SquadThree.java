package game;

public class SquadThree extends SuperSquad {

	private InimigoComum[] verbot = new InimigoComum[5];

	public SquadThree(int hp) {
		super(1024, -150, false, 0, 0, "");
		setControlTela(200);
		setHp(hp);
		setControl(5);
	}

	public void SquadTree() {
		for (int i = 0; i < verbot.length; i++) {
			verbot[i] = new InimigoComum(getHp(), getPosX(), getPosY() + getControlTela(), "images/Verbot2.png", 4,45);
			setControlTela(getControlTela() + 125);
			verbot[i].setPosicaoTela(1);
			verbot[i].setWidth(63);
			verbot[i].setHeight(25);
			setVerbot(verbot);
			if (getControl() == 0) {
				setControle(true);
			}
		}
		verbot[1] = new InimigoComum(700, verbot[1].getPosX(), verbot[1].getPosY(), "images/Verbot3.png", 4,40);
		verbot[2] = new InimigoComum(700, verbot[2].getPosX(), verbot[2].getPosY(), "images/Verbot3.png", 4,40);
		verbot[3] = new InimigoComum(700, verbot[3].getPosX(), verbot[3].getPosY(), "images/Verbot3.png", 4,40);
		verbot[1].setWidth(113);
		verbot[1].setHeight(59);
		verbot[2].setWidth(113);
		verbot[2].setHeight(59);
		verbot[3].setWidth(113);
		verbot[3].setHeight(59);
		verbot[1].setPosicaoTela(3);
		verbot[3].setPosicaoTela(3);
		verbot[2].setPosicaoTela(5);
	}

}
