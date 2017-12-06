package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class TelaEstatica {

	private Color corDeFundo;
	private boolean visivel;
	private Botao[] botoes;
	private Image imagemDeFundo;

	//Construtor usando apenas a cor como fundo
	public TelaEstatica(Color corDeFundo, boolean visivel) {
		super();
		this.corDeFundo = corDeFundo;
		this.visivel = visivel;
	}
	//Construtor usando imagem como fundo
	public TelaEstatica(String imagem, boolean visivel) {
		super();
		this.imagemDeFundo = Utils.getInstance().loadImage(imagem);
		this.visivel = visivel;
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

	//Método para desenhar com cor apenas
	
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
	//Método para desenhar IBAGEM, EU QUERO IBAGENS
	
	public void drawImage(Graphics2D g){
		g.drawImage(imagemDeFundo, 0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(), null);
		if (botoes != null) {
			for (Botao b : botoes) {
				b.draw(g);
			}
		}
	}
}
