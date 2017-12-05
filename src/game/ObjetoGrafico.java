package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;

import br.senai.sc.engine.Utils;

public abstract class ObjetoGrafico implements Serializable{

	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -1070618983465225504L;
	/**
	 * 
	 */
	// O objeto gráfico é algo que vai ser desenhado em alguma posição da tela
	protected int posX;
	protected int posY;
	protected int width;
	protected int height;
	protected transient Image sprite;
	public ObjetoGrafico(int posX, int posY, int width, int height, String fileName) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		sprite = Utils.getInstance().loadImage(fileName);
	}
	public ObjetoGrafico(){
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public void draw(Graphics2D g) {
		g.drawImage(sprite, posX, posY, null);
	}

	public Rectangle getRectangle() {
		return new Rectangle(posX, posY, width, height);
	}

}
