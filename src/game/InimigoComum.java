package game;

import br.senai.sc.engine.Utils;

public class InimigoComum extends SuperInimigo {
	private int dano;
	boolean destruido;

	public InimigoComum(int hP, int posX, int posY) {
		super(posX, posY, 119, 112, "images/sonicDoMal.png", 15, 15, 0, 0, 7, 3, hP);

	}

	public void update() {
		setFrameY(1);
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= 7) {
			setFrameX(0);
		}
		if (getHp() <= 0) {
			destruido = true;
		} else {
			destruido = false;
		}
        if(getPosX()+getWidth()>Utils.getInstance().getWidth()){
        	setPosX(getPosX()-getVelX());
        }
	}

	public boolean isDestruido() {
		return destruido;
	}

	public void setDestruido(boolean destruido) {
		this.destruido = destruido;
	}

}
