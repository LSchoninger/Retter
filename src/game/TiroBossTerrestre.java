package game;

public class TiroBossTerrestre extends SuperTiro {

	public TiroBossTerrestre(int posX, int posY) {
		super(posX, posY, 16, 32, "images/TiroBossTanque.png", 0, 7, 450, 10000);
	}

	public void update(){
		setPosY(getPosY()-getVelY());
	}
}
