package game;

public class BossTiroMega extends SuperTiro {

	public BossTiroMega(BossFinal boss) {
		super(0, 0, 1530, 21, "images/TiroBossMega.png",7, 0, 300, 10000);
		setPosX(-790);
		setPosY(boss.getPosY() + 5);
	}

	public void update() {
		setPosX(getPosX() - getVelX());
	}
}
