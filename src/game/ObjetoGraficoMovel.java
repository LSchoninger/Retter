package game;

import java.io.Serializable;

public abstract class ObjetoGraficoMovel extends ObjetoGrafico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3405870334569812065L;
	//É um objeto com velocidade
	protected int velX;
	protected int velY;
	
	public ObjetoGraficoMovel(int posX, int posY, int width, int height, String fileName, int velX, int velY) {
		super(posX, posY, width, height, fileName);
		this.velX = velX;
		this.velY = velY;
	}
	public ObjetoGraficoMovel(){
		super();
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public abstract void update();
	
}
