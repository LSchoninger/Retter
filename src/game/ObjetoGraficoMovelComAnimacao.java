package game;

import java.awt.Graphics2D;

public abstract class ObjetoGraficoMovelComAnimacao extends ObjetoGraficoMovel {
	
	//Possui mais os atributos de animação
	private int frameX;
	private int frameY;
	private int cols;
	private int rows;

	public ObjetoGraficoMovelComAnimacao(int posX, int posY, int width, int height, String fileName, int velX, int velY,
			int frameX, int frameY, int cols, int rows) {
		super(posX, posY, width, height, fileName, velX, velY);
		this.frameX = frameX;
		this.frameY = frameY;
		this.cols = cols;
		this.rows = rows;
	}

	public int getFrameX() {
		return frameX;
	}

	public void setFrameX(int frameX) {
		this.frameX = frameX;
	}

	public int getFrameY() {
		return frameY;
	}

	public void setFrameY(int frameY) {
		this.frameY = frameY;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getPosX()+getWidth(), getPosY()+getHeight(),
				frameX*getWidth(), frameY*getHeight(), frameX*getWidth()+getWidth(), frameY*getHeight()+getHeight(), null);
	}
	
	@Override
	public void update() {
		
		if (frameX >= cols) {
			frameX = 0;
		}
	}

}
