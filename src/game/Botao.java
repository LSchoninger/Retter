package game;

public class Botao extends ObjetoGrafico {

	public Botao(int posX, int posY, int width, int height, String fileName) {
		super(posX, posY, width, height, fileName);
	}

	// Caso quisermos clicar no botao, passamos por parametro as posições X e Y do mouse
	public boolean click(int x, int y) {
		if (x >= getPosX() && x <= getPosX() + getWidth() && 
			y >= getPosY() && y <= getPosY() + getHeight()) {
			return true;
		}
		return false;
	}
	
}
