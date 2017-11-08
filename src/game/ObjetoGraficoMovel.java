package game;

public abstract class ObjetoGraficoMovel extends ObjetoGrafico {

	//É um objeto com velocidade
	private int velX;
	private int velY;
	
	public ObjetoGraficoMovel(int posX, int posY, int width, int height, String fileName, int velX, int velY) {
		super(posX, posY, width, height, fileName);
		this.velX = velX;
		this.velY = velY;
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
