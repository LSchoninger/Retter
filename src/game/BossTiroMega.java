package game;

public class BossTiroMega extends SuperTiro {

	public BossTiroMega(BossFinal boss) {
		super(-15, -15, 1530, 15, "images/TiroMegaBoss.png",7, 0, 1000, 10000);
		setPosX(-860);
		setPosY(boss.getPosY()+3);
		setDano(1000);
	}

	public void update() {
		setPosX(getPosX() - getVelX());
	}
}
