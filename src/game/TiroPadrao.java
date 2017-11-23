package game;

import br.senai.sc.engine.Utils;

public class TiroPadrao extends SuperTiro {

	public TiroPadrao(int posX, int posY, int dano) {
		super(posX, posY, 3, 6, "images/TiroPadrao.png", 40, 40, 50, 100);

	}

	public void update() {
		setPosX(getPosX() + getVelX());

	}

	@Override
	public int getDano() {
		// TODO Auto-generated method stub
		return super.getDano();
	}

	
}
