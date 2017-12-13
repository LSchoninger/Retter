package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class TelaEstatica {

	private Color corDeFundo;
	private boolean visivel;
	private Botao[] botoes;
	private Image[] imagemDeFundo;
	private int posX;
	private int posY;
	private int posY2;

	public TelaEstatica() {
	}

	public TelaEstatica(Color corDeFundo, boolean visivel) {
		super();
		this.corDeFundo = corDeFundo;
		this.visivel = visivel;
	}

	public TelaEstatica(String imagem, boolean visivel) {
		super();
		this.imagemDeFundo = new Image[2];
		this.imagemDeFundo[0] = Utils.getInstance().loadImage(imagem);
		this.imagemDeFundo[1] = Utils.getInstance().loadImage(imagem);
		this.visivel = visivel;
		posY2 -= Utils.getInstance().getHeight();
	}

	public void update() {
		posY += 5;
		posY2 += 5;
		if (posY >= Utils.getInstance().getHeight()) {
			posY = 0 - Utils.getInstance().getHeight();
		}
		if (posY2 >= Utils.getInstance().getHeight()) {
			posY2 = 0 - Utils.getInstance().getHeight();
		}
	}

	public Color getCorDeFundo() {
		return corDeFundo;
	}

	public void setCorDeFundo(Color corDeFundo) {
		this.corDeFundo = corDeFundo;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public Botao[] getBotoes() {
		return botoes;
	}

	public void setBotoes(Botao[] botoes) {
		this.botoes = botoes;
	}

	// Método para desenhar com cor apenas

	public void draw(Graphics2D g) {
		g.setColor(corDeFundo);
		g.fillRect(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight());
		if (botoes != null) {
			// FOR EACH, já sai com o objeto em cada posição
			for (Botao b : botoes) {
				b.draw(g);
			}
		}
	}
	// Método para desenhar IBAGEM, EU QUERO IBAGENS

	public void drawImage(Graphics2D g) {
		g.drawImage(imagemDeFundo[0], posX, posY, Utils.getInstance().getWidth(), Utils.getInstance().getHeight() + 15,
				null);
		g.drawImage(imagemDeFundo[1], posX, posY2, Utils.getInstance().getWidth(), Utils.getInstance().getHeight() + 15,
				null);
		if (botoes != null) {
			for (Botao b : botoes) {
				b.draw(g);
			}
		}
	}

	public void drawImageOnly(Graphics2D g) {
		g.drawImage(imagemDeFundo[0], posX, posY, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(),
				null);
		if (botoes != null) {
			for (Botao b : botoes) {
				b.draw(g);
			}
		}
	}

	public Image[] getImagemDeFundo() {
		return imagemDeFundo;
	}

	public void setImagemDeFundo(Image imagemDeFundo, int index) {
		this.imagemDeFundo = new Image[2];
		this.imagemDeFundo[0] = imagemDeFundo;
	}
}
